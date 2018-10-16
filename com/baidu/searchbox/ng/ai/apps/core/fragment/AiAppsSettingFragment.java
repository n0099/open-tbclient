package com.baidu.searchbox.ng.ai.apps.core.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsAccreditNode;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHelper;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.TaskResult;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Authorize;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate;
import com.baidu.searchbox.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class AiAppsSettingFragment extends AiAppsBaseFragment implements AdapterView.OnItemClickListener {
    private static final boolean DEBUG = false;
    public static String PREF_CLOSE_SCOPE_ALERT_SHOWED = "pref_close_scope_alert_showed";
    public static final String TAG = "AiAppsSettingFragment";
    private FrameLayout mContainer;
    private BaseAdapter mListAdapter;
    private final List<ScopeInfo> mList = new ArrayList();
    private boolean mAuthorizing = false;

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.aiapps_setting_fragment, viewGroup, false);
        initActionBar(inflate);
        this.mAiAppsActionBar.setRightImgZone2Visibility(8);
        this.mContainer = (FrameLayout) inflate.findViewById(R.id.container);
        this.mListAdapter = createAdapter();
        ListView listView = (ListView) inflate.findViewById(R.id.ai_apps_setting_list);
        listView.setAdapter((ListAdapter) this.mListAdapter);
        listView.setOnItemClickListener(this);
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void initActionBar(View view) {
        super.initActionBar(view);
        setActionBarBackgroundColor(-1);
        setNavigationBarFrontColor(-16777216);
        setActionbarTitle(getString(R.string.common_menu_authority_management));
        setBackViewVisible(true);
        setRightMenuVisibility(false);
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarSettingPressed() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.mAuthorizing) {
            this.mAuthorizing = true;
            ScopeInfo scopeInfo = this.mList.get(i);
            if (!scopeInfo.authorized() || getAiApp().getSetting().getBoolean(PREF_CLOSE_SCOPE_ALERT_SHOWED, false)) {
                OAuthUtils.log("onItemClick : " + scopeInfo, false);
                toggleItem(scopeInfo);
                return;
            }
            showCloseAlert(scopeInfo);
        }
    }

    private void showCloseAlert(final ScopeInfo scopeInfo) {
        new AiAppAlertDialog.Builder(getActivity()).setTitle(R.string.aiapps_setting_scope_close_alert_title).setMessage(R.string.aiapps_setting_scope_close_alert_msg).setDecorate(new AiAppsDialogDecorate()).setPositiveButton(R.string.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsSettingFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AiAppsSettingFragment.this.getAiApp().getSetting().putBoolean(AiAppsSettingFragment.PREF_CLOSE_SCOPE_ALERT_SHOWED, true);
                AiAppsSettingFragment.this.toggleItem(scopeInfo);
            }
        }).setNegativeButton(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsSettingFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AiAppsSettingFragment.this.mAuthorizing = false;
            }
        }).setCancelable(true).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsSettingFragment.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                AiAppsSettingFragment.this.mAuthorizing = false;
            }
        }).show();
    }

    private void initData() {
        LoadingViewHelper.showLoadingView(getActivity(), this.mContainer);
        AiAppsAccreditNode.getAccreditListData(new TypedCallback<Map<String, ScopeInfo>>() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsSettingFragment.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Map<String, ScopeInfo> map) {
                if (AiAppsSettingFragment.this.getActivity() != null) {
                    LoadingViewHelper.dismissLoadingView(AiAppsSettingFragment.this.mContainer);
                    if (map != null) {
                        AiAppsSettingFragment.this.mList.clear();
                        for (Map.Entry<String, ScopeInfo> entry : map.entrySet()) {
                            ScopeInfo value = entry.getValue();
                            if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.forbidden && value.explicitly() && "2".equals(value.grade) && !ScopeInfo.SCOPE_ID_SNSAPI_BASE.equals(value.id)) {
                                AiAppsSettingFragment.this.mList.add(value);
                            }
                        }
                        AiAppsSettingFragment.this.updateUi();
                        AiAppsSettingFragment.this.mListAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    @Nullable
    public AiApp getAiApp() {
        return AiAppsController.getInstance().getAiApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUi() {
        boolean isEmpty = this.mList.isEmpty();
        TextView textView = (TextView) getView().findViewById(R.id.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(getString(R.string.aiapps_setting_tips, getAiApp().getName()));
        }
        TextView textView2 = (TextView) getView().findViewById(R.id.empty);
        textView2.setVisibility(isEmpty ? 0 : 8);
        if (isEmpty) {
            textView2.setText(getString(R.string.aiapps_setting_empty, getAiApp().getName()));
        }
    }

    private BaseAdapter createAdapter() {
        return new BaseAdapter() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsSettingFragment.5
            @Override // android.widget.Adapter
            public int getCount() {
                return AiAppsSettingFragment.this.mList.size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.widget.Adapter
            public ScopeInfo getItem(int i) {
                return (ScopeInfo) AiAppsSettingFragment.this.mList.get(i);
            }

            @Override // android.widget.Adapter
            public long getItemId(int i) {
                return getItem(i).hashCode();
            }

            @Override // android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null || !(view.getTag() instanceof ViewHolder)) {
                    view = View.inflate(AiAppsSettingFragment.this.getContext(), R.layout.aiapps_setting_item, null);
                    ViewHolder viewHolder = new ViewHolder();
                    viewHolder.checkBox = (CheckBox) view.findViewById(R.id.checkbox);
                    viewHolder.title = (TextView) view.findViewById(R.id.title);
                    view.setTag(viewHolder);
                }
                ViewHolder viewHolder2 = (ViewHolder) view.getTag();
                ScopeInfo item = getItem(i);
                String str = TextUtils.isEmpty(item.shortName) ? item.name : item.shortName;
                TextView textView = viewHolder2.title;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                viewHolder2.checkBox.setChecked(item.authorized());
                return view;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleItem(ScopeInfo scopeInfo) {
        authorize(scopeInfo, !scopeInfo.authorized());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateItemFlag(ScopeInfo scopeInfo, boolean z) {
        scopeInfo.tipStatus = z ? 1 : -1;
        this.mListAdapter.notifyDataSetChanged();
    }

    private void authorize(final ScopeInfo scopeInfo, boolean z) {
        AiApp aiApp = getAiApp();
        if (aiApp == null) {
            this.mAuthorizing = false;
            return;
        }
        LoadingViewHelper.showLoadingView(getActivity(), this.mContainer);
        aiApp.getSetting().authorize(getActivity(), scopeInfo.id, z, true, new TypedCallback<TaskResult<Authorize.Result>>() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsSettingFragment.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(TaskResult<Authorize.Result> taskResult) {
                FragmentActivity activity = AiAppsSettingFragment.this.getActivity();
                if (activity != null) {
                    LoadingViewHelper.dismissLoadingView(AiAppsSettingFragment.this.mContainer);
                    if (taskResult != null && taskResult.isOk()) {
                        AiAppsSettingFragment.this.updateItemFlag(scopeInfo, taskResult.mData.permit);
                    } else {
                        UniversalToast.makeText(activity, R.string.aiapps_setting_scope_auth_failed).showToast();
                    }
                    AiAppsSettingFragment.this.mAuthorizing = false;
                }
            }
        });
    }

    /* loaded from: classes2.dex */
    class ViewHolder {
        CheckBox checkBox;
        TextView title;

        ViewHolder() {
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getAiApp().getSetting().notifySettingFinish();
    }

    public static AiAppsSettingFragment newInstance() {
        return new AiAppsSettingFragment();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean isTabFragment() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean handleBackPressed() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void initToolMenu() {
    }
}
