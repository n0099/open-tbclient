package com.baidu.searchbox.ng.ai.apps.core.fragment;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsPropertyWindow;
import com.baidu.searchbox.ng.ai.apps.console.ConsoleController;
import com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppFeedbackIoc;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdBaseImageView;
import com.baidu.searchbox.ng.ai.apps.res.ui.FullScreenFloatView;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.shortcut.AiAppsShortcutHelper;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.swancore.AboutDevSwanCoreHistory;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsRoundedImageView;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsMenuDecorate;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenu;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenuItem;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenuStatisticConstants;
import com.baidu.searchbox.ng.aiapps.menu.OnAiAppMenuItemClickListener;
import com.baidu.searchbox.support.v4.app.FragmentActivity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsAboutFragment extends AiAppsBaseFragment implements View.OnClickListener {
    private static final String BUNDLE_KEY_APP_ID = "aiapps_feedback_app_id";
    private static final boolean DEBUG = false;
    private static final String SESSION_DISPLAYNAME = "BoxAccount_displayname";
    private static final String SESSION_UID = "BoxAccount_uid";
    private static final String TAG = "AiAppsAboutFragment";
    private Button mAiAppsButton;
    private TextView mAiAppsDescription;
    private AiAppsRoundedImageView mAiAppsIcon;
    private BdBaseImageView mAiAppsLabelBg;
    private TextView mAiAppsLabelTv;
    private Button mAiAppsOpenApp;
    private TextView mAiAppsTitle;
    private long[] mHits = new long[5];
    private TextView mServiceCategoryValue;
    private TextView mSubjectInfoValue;

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.aiapps_about_fragment, viewGroup, false);
        initActionBar(inflate);
        initView(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void initActionBar(View view) {
        super.initActionBar(view);
        setActionBarBackgroundColor(-1);
        setNavigationBarFrontColor(-16777216);
        setActionbarTitle(null);
        setBackViewVisible(true);
    }

    private void initView(View view) {
        AiApp aiApp = AiApp.get();
        if (aiApp != null && aiApp.getLaunchInfo() != null) {
            AiAppsLaunchInfo launchInfo = aiApp.getLaunchInfo();
            this.mAiAppsIcon = (AiAppsRoundedImageView) view.findViewById(R.id.aiapps_icon);
            this.mAiAppsTitle = (TextView) view.findViewById(R.id.aiapps_title);
            this.mAiAppsDescription = (TextView) view.findViewById(R.id.aiapps_description);
            this.mServiceCategoryValue = (TextView) view.findViewById(R.id.service_category_value);
            this.mSubjectInfoValue = (TextView) view.findViewById(R.id.subject_info_value);
            this.mAiAppsLabelTv = (TextView) view.findViewById(R.id.aiapps_label_tv);
            this.mAiAppsLabelBg = (BdBaseImageView) view.findViewById(R.id.aiapps_label_bg);
            this.mAiAppsIcon.setImageBitmap(launchInfo.mAppIcon);
            this.mAiAppsTitle.setText(launchInfo.mAppTitle);
            this.mAiAppsDescription.setText(launchInfo.mDescription);
            this.mServiceCategoryValue.setText(launchInfo.mServiceCategory);
            this.mSubjectInfoValue.setText(launchInfo.mSubjectInfo);
            this.mAiAppsButton = (Button) view.findViewById(R.id.into_aiapps_button);
            this.mAiAppsButton.setOnClickListener(this);
            initAiAppLabel(AiApp.get().getLaunchInfo().mType);
            setIconClick();
            this.mAiAppsOpenApp = (Button) view.findViewById(R.id.open_app_button);
            this.mAiAppsOpenApp.setVisibility(8);
            if (AiAppsController.getInstance().isSupportDebug()) {
                ((ViewStub) view.findViewById(R.id.ai_app_console)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.1
                    FullScreenFloatView mConsoleButton;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ConsoleController.toggleConsole(AiAppsAboutFragment.this.getContext());
                    }
                });
                ((ViewStub) view.findViewById(R.id.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.2
                    AiAppsPropertyWindow mPropertyWindow;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (this.mPropertyWindow == null) {
                            this.mPropertyWindow = AiAppsController.getInstance().initPropertyWindow(AiAppsAboutFragment.this.mActivity);
                        }
                        this.mPropertyWindow.setVisibility(this.mPropertyWindow.getVisibility() == 0 ? 8 : 0);
                    }
                });
                ((ViewStub) view.findViewById(R.id.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AiApp aiApp2;
                        if (AiAppsAboutFragment.this.mActivity != null && (aiApp2 = AiApp.get()) != null && aiApp2.getLaunchInfo() != null) {
                            AiAppsLaunchInfo launchInfo2 = aiApp2.getLaunchInfo();
                            StringBuilder sb = new StringBuilder();
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(launchInfo2.mVersion) ? "" : launchInfo2.mVersion).append("\n");
                            sb.append("APPID VERSION: ").append(AiAppsApsUtils.getAiAppIdVersion(aiApp2.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), launchInfo2.mAppZipSize);
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(launchInfo2.mAppZipSize).append(")").append("\n");
                            AiAppAlertDialog.Builder builder = new AiAppAlertDialog.Builder(AiAppsAboutFragment.this.mActivity);
                            builder.setTitle(AiAppsAboutFragment.this.mActivity.getResources().getString(R.string.aiapps_show_ext_info_title)).setMessage(sb.toString()).setDecorate(new AiAppsDialogDecorate()).setCancelable(false);
                            builder.setPositiveButton(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            builder.show();
                        }
                    }
                });
                View inflate = ((ViewStub) view.findViewById(R.id.ai_app_swan_core_history_info)).inflate();
                if (inflate instanceof Button) {
                    Button button = (Button) inflate;
                    button.setText(R.string.aiapps_debug_swan_core_version);
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (AiAppsAboutFragment.this.mActivity != null) {
                                String swanCoreHistoryListString = AboutDevSwanCoreHistory.getIns().getSwanCoreHistoryListString();
                                AiAppAlertDialog.Builder builder = new AiAppAlertDialog.Builder(AiAppsAboutFragment.this.mActivity);
                                builder.setTitle(AiAppsAboutFragment.this.mActivity.getResources().getString(R.string.aiapps_swan_core_history_title)).setMessage(swanCoreHistoryListString).setDecorate(new AiAppsDialogDecorate()).setCancelable(false);
                                builder.setPositiveButton(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                builder.show();
                            }
                        }
                    });
                }
            }
        }
    }

    private void initAiAppLabel(int i) {
        AiAppsUIUtils.isShowIconLabel(this.mAiAppsLabelBg, this.mAiAppsLabelTv, String.valueOf(i));
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void initToolMenu() {
        FragmentActivity activity = getActivity();
        if (activity != null && this.mToolMenu == null) {
            this.mToolMenu = new AiAppMenu(activity, this.mAiAppsActionBar, 13, new AiAppsMenuDecorate());
            this.mToolMenu.setStatisticSource(AiAppMenuStatisticConstants.SOURCE_TOOL);
            this.mToolMenu.setMenuSource("swan");
            toolMenuItemClickListener();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarSettingPressed() {
        initToolMenu();
        this.mToolMenu.show(AiAppNightModeHelper.getNightModeSwitcherState());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean isTabFragment() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean handleBackPressed() {
        return false;
    }

    public static AiAppsAboutFragment newInstance() {
        return new AiAppsAboutFragment();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AiApp aiApp;
        int id = view.getId();
        if (id == R.id.into_aiapps_button) {
            AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
            if (aiAppsFragmentManager == null) {
                UniversalToast.makeText(this.mActivity, R.string.aiapps_open_fragment_failed_toast).showToast();
            } else {
                aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_BACK).setCustomAnimations(0, AiAppsFragmentManager.ANIM_EXIT).popFragment().commit();
            }
        } else if (id == R.id.open_app_button && (aiApp = AiApp.get()) != null && aiApp.getLaunchInfo() != null) {
            AiAppsLaunchInfo launchInfo = aiApp.getLaunchInfo();
            String str = launchInfo.mAppOpenUrl;
            String str2 = launchInfo.mAppDownloadUrl;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String generateOpenAppScheme = AiAppsUtils.generateOpenAppScheme(str, str2);
                UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
                unitedSchemeMainDispatcher.setDynamicDispatcher("swan", new UnitedSchemeAiAppDispatcher());
                UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(generateOpenAppScheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
                unitedSchemeEntity.setOnlyVerify(false);
                unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            }
        }
    }

    private void toolMenuItemClickListener() {
        this.mToolMenu.setOnItemClickListener(new OnAiAppMenuItemClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.5
            @Override // com.baidu.searchbox.ng.aiapps.menu.OnAiAppMenuItemClickListener
            public boolean onClick(View view, AiAppMenuItem aiAppMenuItem) {
                switch (aiAppMenuItem.getItemId()) {
                    case 9:
                        AiApp aiApp = AiApp.get();
                        if (aiApp == null) {
                            return true;
                        }
                        TreeSet treeSet = new TreeSet();
                        treeSet.add(AiAppsAboutFragment.SESSION_UID);
                        treeSet.add(AiAppsAboutFragment.SESSION_DISPLAYNAME);
                        Map<String, String> sessions = aiApp.getAccount().getSessions(AiAppsAboutFragment.this.getContext(), treeSet);
                        Bundle bundle = new Bundle();
                        bundle.putString(AiAppsAboutFragment.SESSION_UID, sessions.get(AiAppsAboutFragment.SESSION_UID));
                        bundle.putString(AiAppsAboutFragment.SESSION_DISPLAYNAME, sessions.get(AiAppsAboutFragment.SESSION_DISPLAYNAME));
                        bundle.putString(AiAppsAboutFragment.BUNDLE_KEY_APP_ID, AiApp.getAiAppId());
                        AiAppsRuntime.getFeedbackRuntime().feedback(bundle, new IAiAppFeedbackIoc.OnFeedbackResultCallback() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.5.1
                            @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppFeedbackIoc.OnFeedbackResultCallback
                            public void onResult(final String str) {
                                AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.5.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (TextUtils.equals(new JSONObject(str).optString("result"), "success")) {
                                                UniversalToast.makeText(AiAppsRuntime.getAppContext(), R.string.aiapps_report_tips).setDuration(2).showToast();
                                            }
                                        } catch (JSONException e) {
                                        }
                                    }
                                });
                            }
                        });
                        return true;
                    case 35:
                        AiAppsShortcutHelper.addShortcut(view.getContext(), AiApp.get().getLaunchInfo());
                        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
                        aiAppsUBCEvent.mValue = AiAppsUBCStatistic.VALUE_ADD_SHORTCUT;
                        AiAppsAboutFragment.this.doUBCEventStatistic(aiAppsUBCEvent);
                        return true;
                    case 37:
                        AiAppsAboutFragment.this.startSettingFragment();
                        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent2 = new AiAppsUBCStatistic.AiAppsUBCEvent();
                        aiAppsUBCEvent2.mValue = AiAppsUBCStatistic.VALUE_PERMISSION;
                        AiAppsAboutFragment.this.doUBCEventStatistic(aiAppsUBCEvent2);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setIconClick() {
        if (this.mAiAppsIcon != null) {
            this.mAiAppsIcon.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsAboutFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(AiAppsAboutFragment.this.mHits, 1, AiAppsAboutFragment.this.mHits, 0, AiAppsAboutFragment.this.mHits.length - 1);
                    AiAppsAboutFragment.this.mHits[AiAppsAboutFragment.this.mHits.length - 1] = SystemClock.uptimeMillis();
                    if (AiAppsAboutFragment.this.mHits[0] >= SystemClock.uptimeMillis() - 1000) {
                        AiAppsAboutFragment.this.showEggInfo();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSettingFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            UniversalToast.makeText(this.mActivity, R.string.aiapps_open_fragment_failed_toast).showToast();
        } else {
            aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_TO).setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment(AiAppsFragmentManager.SETTING, null).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEggInfo() {
        AiAppsLaunchInfo launchInfo;
        if (AiApp.get() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("swan-core version : ").append(AiAppsSwanCoreManager.getSwanCoreVersionString(AiAppsCoreRuntime.getInstance().getSwanCoreVersion()));
            sb.append("\n");
            String commitId = AiAppsRuntime.getConfigRuntime().getCommitId();
            if (!TextUtils.isEmpty(commitId) && commitId.length() > 7) {
                commitId = commitId.substring(0, 7);
            }
            sb.append("commitId : ").append(commitId);
            sb.append("\n");
            sb.append("buildTime : ").append(AiAppsRuntime.getConfigRuntime().getBuildTime());
            sb.append("\n");
            sb.append("version : ").append(AiAppsUtils.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && AiApp.get() != null && AiApp.get().getLaunchInfo() != null && (launchInfo = AiApp.get().getLaunchInfo()) != null) {
                sb.append("aps version: ").append(TextUtils.isEmpty(launchInfo.mVersion) ? "" : launchInfo.mVersion).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), launchInfo.mAppZipSize);
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
            }
            UniversalToast.makeText(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.mHits = new long[5];
        }
    }
}
