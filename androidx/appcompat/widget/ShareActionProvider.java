package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ShareActionProvider extends ActionProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public int mMaxShownActivityCount;
    public ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    public final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    public OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    public String mShareHistoryFileName;

    /* loaded from: classes.dex */
    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    /* loaded from: classes.dex */
    public class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareActionProvider this$0;

        public ShareActivityChooserModelPolicy(ShareActionProvider shareActionProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareActionProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = shareActionProvider;
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, activityChooserModel, intent)) == null) {
                ShareActionProvider shareActionProvider = this.this$0;
                OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.mOnShareTargetSelectedListener;
                if (onShareTargetSelectedListener != null) {
                    onShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareActionProvider this$0;

        public ShareMenuItemOnMenuItemClickListener(ShareActionProvider shareActionProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareActionProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = shareActionProvider;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, menuItem)) == null) {
                ShareActionProvider shareActionProvider = this.this$0;
                Intent chooseActivity = ActivityChooserModel.get(shareActionProvider.mContext, shareActionProvider.mShareHistoryFileName).chooseActivity(menuItem.getItemId());
                if (chooseActivity != null) {
                    String action = chooseActivity.getAction();
                    if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                        this.this$0.updateIntent(chooseActivity);
                    }
                    this.this$0.mContext.startActivity(chooseActivity);
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareActionProvider(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener(this);
        this.mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = context;
    }

    private void setActivityChooserPolicyIfNeeded() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.mOnShareTargetSelectedListener == null) {
            return;
        }
        if (this.mOnChooseActivityListener == null) {
            this.mOnChooseActivityListener = new ShareActivityChooserModelPolicy(this);
        }
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ActivityChooserView activityChooserView = new ActivityChooserView(this.mContext);
            if (!activityChooserView.isInEditMode()) {
                activityChooserView.setActivityChooserModel(ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
            }
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
            activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, typedValue.resourceId));
            activityChooserView.setProvider(this);
            activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
            activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
            return activityChooserView;
        }
        return (View) invokeV.objValue;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu subMenu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subMenu) == null) {
            subMenu.clear();
            ActivityChooserModel activityChooserModel = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
            PackageManager packageManager = this.mContext.getPackageManager();
            int activityCount = activityChooserModel.getActivityCount();
            int min = Math.min(activityCount, this.mMaxShownActivityCount);
            for (int i2 = 0; i2 < min; i2++) {
                ResolveInfo activity = activityChooserModel.getActivity(i2);
                subMenu.add(0, i2, i2, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
            }
            if (min < activityCount) {
                SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
                for (int i3 = 0; i3 < activityCount; i3++) {
                    ResolveInfo activity2 = activityChooserModel.getActivity(i3);
                    addSubMenu.add(0, i3, i3, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
                }
            }
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onShareTargetSelectedListener) == null) {
            this.mOnShareTargetSelectedListener = onShareTargetSelectedListener;
            setActivityChooserPolicyIfNeeded();
        }
    }

    public void setShareHistoryFileName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mShareHistoryFileName = str;
            setActivityChooserPolicyIfNeeded();
        }
    }

    public void setShareIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                    updateIntent(intent);
                }
            }
            ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(intent);
        }
    }

    public void updateIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                intent.addFlags(134742016);
            } else {
                intent.addFlags(524288);
            }
        }
    }
}
