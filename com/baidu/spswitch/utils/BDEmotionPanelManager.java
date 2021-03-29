package com.baidu.spswitch.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.R;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.adapter.NoHorizontalScrollerVPAdapter;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BDEmotionPanelManager {
    public static final int COLOR_EMOTION_TYPE_LAYOUT = -657931;
    public static final int COLOR_EMOTION_TYPE_PLACEHOLDER = -1;
    public static final int NIGHT_COLOR_EMOTION_TYPE_LAYOUT = -13421773;
    public static final int NIGHT_COLOR_EMOTION_TYPE_PLACEHOLDER = -14540254;
    public static final String TAG = "BDEmotionPanelManager";
    public static volatile BDEmotionPanelManager sInstance;
    public boolean isNightMode;
    public String mLastStackInfo;
    public static final boolean DEBUG = SPConfig.isDebug();
    public static Handler sMainHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public interface OnEmotionClickListener {
        void onEmotionClick(EmotionType emotionType, int i, String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface OnVerticalEmotionListener {
        public static final int SECTION_TYPE_ALL = 1;
        public static final int SECTION_TYPE_OFTEN = 0;

        void onVerticalEmotionClick(EmotionType emotionType, int i, String str, String str2, int i2, int i3);

        void onVerticalEmotionLongClick(EmotionType emotionType, int i, String str, String str2, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLoadInnerEmotionPanel(Activity activity, ViewGroup viewGroup, View view, boolean z) {
        if (!(viewGroup instanceof SPSwitchPanelLinearLayout)) {
            if (DEBUG) {
                throw new IllegalArgumentException("panelLayout must be SPSwitchLinearLayout");
            }
        } else if (!(view instanceof EditText)) {
            if (DEBUG) {
                throw new IllegalArgumentException("focus view must be EditText");
            }
        } else if (!(activity instanceof FragmentActivity)) {
            if (DEBUG) {
                throw new IllegalArgumentException("host activity must be fragment activity");
            }
        } else {
            this.isNightMode = z;
            handleEmotionTypeLayoutNightMode(viewGroup);
            GlobalOnItemClickListenerManager.getInstance().attachToEditText((EditText) view);
            BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout = new BDEmotionBagVerticalLayout(AppRuntime.getAppContext());
            bDEmotionBagVerticalLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.dip2px(AppRuntime.getAppContext(), 260.0f)));
            bDEmotionBagVerticalLayout.setEmotionList(EmotionUtils.getInstance().getPanelEmotionList());
            ArrayList arrayList = new ArrayList();
            arrayList.add(bDEmotionBagVerticalLayout);
            ((ViewPager) viewGroup.findViewById(R.id.vp_emotion_type)).setAdapter(new NoHorizontalScrollerVPAdapter(arrayList));
        }
    }

    private FragmentManager getFragmentManager(FragmentActivity fragmentActivity) {
        List<Fragment> fragments = fragmentActivity.getSupportFragmentManager().getFragments();
        for (Fragment fragment : fragments) {
            if (fragment.getView() != null && fragment.getView().findViewById(R.id.vp_emotion_type) != null) {
                return fragment.getChildFragmentManager();
            }
        }
        if (fragmentActivity.findViewById(R.id.vp_emotion_type) != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        if (DEBUG) {
            StringBuilder sb = new StringBuilder("emotion panel root layout[id:vp_emotion_type] not found, please recheck:\n");
            sb.append("Activity: " + fragmentActivity + "\n");
            if (fragments != null) {
                sb.append("Fragments: " + fragments + "\n");
            }
            sb.append("stack:\n");
            sb.append(this.mLastStackInfo);
            Log.d(TAG, sb.toString());
        }
        return fragmentActivity.getSupportFragmentManager();
    }

    public static BDEmotionPanelManager getInstance() {
        if (sInstance == null) {
            synchronized (BDEmotionPanelManager.class) {
                if (sInstance == null) {
                    sInstance = new BDEmotionPanelManager();
                }
            }
        }
        return sInstance;
    }

    private void handleEmotionTypeLayoutNightMode(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.emotion_type_placeholer);
        View findViewById2 = viewGroup.findViewById(R.id.emotion_type_layout);
        if (this.isNightMode) {
            findViewById.setBackgroundColor(-14540254);
            findViewById2.setBackgroundColor(-13421773);
        } else {
            findViewById.setBackgroundColor(-1);
            findViewById2.setBackgroundColor(COLOR_EMOTION_TYPE_LAYOUT);
        }
        findViewById2.setVisibility(8);
        findViewById.setVisibility(8);
    }

    public void dismiss() {
        GlobalOnItemClickListenerManager.getInstance().dismiss();
        sInstance = null;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }

    public void loadInnerEmotionPanel(final Activity activity, final ViewGroup viewGroup, final View view, final boolean z) {
        if (DEBUG) {
            this.mLastStackInfo = Log.getStackTraceString(new Exception());
        }
        sMainHandler.post(new Runnable() { // from class: com.baidu.spswitch.utils.BDEmotionPanelManager.1
            @Override // java.lang.Runnable
            public void run() {
                BDEmotionPanelManager.this.doLoadInnerEmotionPanel(activity, viewGroup, view, z);
            }
        });
    }

    public void setOnEmotionClickListener(OnEmotionClickListener onEmotionClickListener) {
        GlobalOnItemClickListenerManager.getInstance().setOnEmotionClickListener(onEmotionClickListener);
    }

    public void setOnVerticalEmotionListener(OnVerticalEmotionListener onVerticalEmotionListener) {
        GlobalOnItemClickListenerManager.getInstance().setOnVerticalEmotionListener(onVerticalEmotionListener);
    }
}
