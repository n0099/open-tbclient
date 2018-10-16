package com.baidu.searchbox.ng.ai.apps.core.fragment;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.adlanding.AiAppsAdLandingFragment;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsParam;
import com.baidu.searchbox.support.v4.app.Fragment;
import com.baidu.searchbox.support.v4.app.FragmentActivity;
import com.baidu.searchbox.support.v4.app.FragmentManager;
import com.baidu.searchbox.support.v4.app.FragmentTransaction;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class AiAppsFragmentManager {
    public static final String ABOUT = "about";
    public static final String ADLANDING = "adLanding";
    public static final int ANIM_ENTER = R.anim.aiapps_slide_in_from_right;
    public static final int ANIM_EXIT = R.anim.aiapps_slide_out_to_right;
    public static final int ANIM_HOLD = R.anim.aiapps_hold;
    public static final int ANIM_NONE = 0;
    private static final boolean DEBUG = false;
    public static final String NORMAL = "normal";
    public static final String SETTING = "setting";
    private static final String TAG = "AiAppsFragmentManager";
    private Activity mActivity;
    private FragmentManager mFragmentManager;
    private ArrayList<AiAppsBaseFragment> mFragmentStack = new ArrayList<>();
    private FragmentOpListener mOpListener;
    private Runnable mPendingRunnable;

    /* loaded from: classes2.dex */
    public interface FragmentOpListener {
        void onFragmentAdd();
    }

    public AiAppsFragmentManager(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.mFragmentManager = fragmentActivity.getSupportFragmentManager();
    }

    public void setFragmentOpListener(FragmentOpListener fragmentOpListener) {
        this.mOpListener = fragmentOpListener;
    }

    public AiAppsBaseFragment getTopFragment() {
        return getFragment(this.mFragmentStack.size() - 1);
    }

    public AiAppsFragment getTopAiAppsFragment() {
        for (int size = this.mFragmentStack.size() - 1; size >= 0; size--) {
            AiAppsBaseFragment aiAppsBaseFragment = this.mFragmentStack.get(size);
            if (aiAppsBaseFragment instanceof AiAppsFragment) {
                return (AiAppsFragment) aiAppsBaseFragment;
            }
        }
        return null;
    }

    public AiAppsBaseFragment getFragment(int i) {
        if (this.mFragmentStack.isEmpty() || i < 0 || i >= this.mFragmentStack.size()) {
            return null;
        }
        return this.mFragmentStack.get(i);
    }

    public AiAppsFragment getTabFragment() {
        if (this.mFragmentStack.isEmpty()) {
            return null;
        }
        int size = this.mFragmentStack.size();
        for (int i = 0; i < size; i++) {
            if (this.mFragmentStack.get(i).isTabFragment()) {
                return (AiAppsFragment) this.mFragmentStack.get(i);
            }
        }
        return null;
    }

    public int getFragmentCount() {
        return this.mFragmentStack.size();
    }

    public TransactionBuilder createTransaction() {
        return new TransactionBuilder("");
    }

    public TransactionBuilder createTransaction(String str) {
        return new TransactionBuilder(str);
    }

    /* loaded from: classes2.dex */
    public class TransactionBuilder {
        private static final int VISIBLE_FRAGMENT_NUM = 1;
        private String mRouteType;
        private FragmentTransaction mTransaction;

        public TransactionBuilder(String str) {
            this.mTransaction = AiAppsFragmentManager.this.mFragmentManager.beginTransaction();
            this.mRouteType = str;
        }

        public TransactionBuilder setCustomAnimations(int i, int i2) {
            this.mTransaction.setCustomAnimations(i, i2);
            return this;
        }

        public TransactionBuilder pushFragment(String str, AiAppsPageParam aiAppsPageParam) {
            AiAppsBaseFragment newInstance;
            if ("about".equals(str)) {
                newInstance = AiAppsAboutFragment.newInstance();
            } else if (AiAppsFragmentManager.SETTING.equals(str)) {
                newInstance = AiAppsSettingFragment.newInstance();
            } else if ("adLanding".equals(str)) {
                newInstance = AiAppsAdLandingFragment.newInstance(aiAppsPageParam);
            } else {
                newInstance = "normal".equals(str) ? AiAppsFragment.newInstance(new AiAppsParam.Builder().setPage(aiAppsPageParam.mPage).setParams(aiAppsPageParam.mParams).setBaseUrl(aiAppsPageParam.mBaseUrl).build()) : null;
            }
            if (newInstance == null) {
                return null;
            }
            return pushFragment(newInstance);
        }

        public TransactionBuilder pushFragment(AiAppsBaseFragment aiAppsBaseFragment) {
            updateVisibleHintBeforePush(aiAppsBaseFragment);
            this.mTransaction.add(R.id.ai_apps_container, aiAppsBaseFragment, AiAppsFragment.TAG);
            AiAppsFragmentManager.this.mFragmentStack.add(aiAppsBaseFragment);
            if (AiAppsFragmentManager.this.mOpListener != null) {
                AiAppsFragmentManager.this.mOpListener.onFragmentAdd();
            }
            return this;
        }

        private void updateVisibleHintBeforePush(final AiAppsBaseFragment aiAppsBaseFragment) {
            final AiAppsBaseFragment topFragment = AiAppsFragmentManager.this.getTopFragment();
            AiAppsFragmentManager.this.mPendingRunnable = new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager.TransactionBuilder.1
                @Override // java.lang.Runnable
                public void run() {
                    if (topFragment != null && topFragment.getUserVisibleHint()) {
                        topFragment.setUserVisibleHint(false);
                    }
                    aiAppsBaseFragment.setUserVisibleHint(true);
                }
            };
        }

        private void updateVisibleHintAfterPop() {
            final AiAppsBaseFragment topFragment = AiAppsFragmentManager.this.getTopFragment();
            AiAppsFragmentManager.this.mPendingRunnable = new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager.TransactionBuilder.2
                @Override // java.lang.Runnable
                public void run() {
                    if (topFragment != null) {
                        topFragment.setUserVisibleHint(true);
                    }
                }
            };
        }

        public TransactionBuilder popFragment() {
            return popFragment(1);
        }

        public TransactionBuilder popFragment(int i) {
            int size;
            if (!AiAppsFragmentManager.this.mFragmentStack.isEmpty()) {
                ArrayList arrayList = (ArrayList) AiAppsFragmentManager.this.mFragmentStack.clone();
                int size2 = arrayList.size() - 1;
                while (true) {
                    int i2 = size2;
                    if (i2 <= (size - i) - 1 || i2 < 0) {
                        break;
                    }
                    this.mTransaction.remove((Fragment) arrayList.get(i2));
                    AiAppsFragmentManager.this.mFragmentStack.remove(i2);
                    size2 = i2 - 1;
                }
                updateVisibleHintAfterPop();
            }
            return this;
        }

        public TransactionBuilder popNonTabFragments() {
            if (!AiAppsFragmentManager.this.mFragmentStack.isEmpty()) {
                ArrayList arrayList = (ArrayList) AiAppsFragmentManager.this.mFragmentStack.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((AiAppsFragment) arrayList.get(size)).isTabFragment()) {
                        this.mTransaction.remove((Fragment) arrayList.get(size));
                        AiAppsFragmentManager.this.mFragmentStack.remove(size);
                    }
                }
                updateVisibleHintAfterPop();
            }
            return this;
        }

        public TransactionBuilder popAllFragments() {
            return popFragment(AiAppsFragmentManager.this.mFragmentStack.size());
        }

        public TransactionBuilder switchFragmentTab(AiAppsPageParam aiAppsPageParam) {
            AiAppsFragment tabFragment = AiAppsFragmentManager.this.getTabFragment();
            if (tabFragment != null) {
                tabFragment.switchTab(aiAppsPageParam);
                return this;
            }
            return pushFragment("normal", aiAppsPageParam);
        }

        private void hideNecessaryFragments() {
            if (!AiAppsFragmentManager.this.mFragmentStack.isEmpty()) {
                int size = AiAppsFragmentManager.this.mFragmentStack.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        this.mTransaction.show((Fragment) AiAppsFragmentManager.this.mFragmentStack.get(i));
                    } else {
                        this.mTransaction.hide((Fragment) AiAppsFragmentManager.this.mFragmentStack.get(i));
                    }
                }
            }
        }

        public void showFragment(AiAppsBaseFragment aiAppsBaseFragment) {
            this.mTransaction.show(aiAppsBaseFragment).commitAllowingStateLoss();
            AiAppsFragmentManager.this.mFragmentManager.executePendingTransactions();
        }

        public void hideFragment(AiAppsBaseFragment aiAppsBaseFragment) {
            this.mTransaction.hide(aiAppsBaseFragment).commitAllowingStateLoss();
            AiAppsFragmentManager.this.mFragmentManager.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.mRouteType)) {
                AiAppsFragment.setRouteType(this.mRouteType);
            }
            if (AiAppsFragmentManager.this.mPendingRunnable != null) {
                AiAppsFragmentManager.this.mPendingRunnable.run();
                AiAppsFragmentManager.this.mPendingRunnable = null;
            }
            hideNecessaryFragments();
            this.mTransaction.commitAllowingStateLoss();
        }

        public boolean commitNow() {
            commit();
            return AiAppsFragmentManager.this.mFragmentManager.executePendingTransactions();
        }
    }
}
