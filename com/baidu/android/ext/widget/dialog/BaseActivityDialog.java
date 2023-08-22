package com.baidu.android.ext.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.skin.ioc.SkinResourcesRuntime;
import com.baidu.tieba.R;
import com.baidu.tieba.x;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String KEY_FOR_BUILDER = "BOX_ACTIVITY_DIALOG_FOR_BUILDER";
    public static final String KEY_FROM = "BOX_ACTIVITY_DIALOG_FROM";
    public static final String KEY_NIGHT_MODE = "BOX_ACTIVITY_DIALOG_NIGHT_MODE";
    public static final String TAG = "BaseActivityDialog";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBtnHeight;
    public LinearLayout mBtnPanelLayout;
    public Builder mBuilder;
    public FrameLayout mDialogContent;
    public FrameLayout mDialogCustomPanel;
    public RelativeLayout mDialogLayout;
    public View mDivider2;
    public View mDivider3;
    public View mDivider4;
    public Handler mHandler;
    public ImageView mIcon;
    public TextView mMessage;
    public LinearLayout mMessageContent;
    public TextView mNegativeButton;
    public TextView mNeutralButton;
    public TextView mPositiveButton;
    public BoxScrollView mScrollView;
    public TextView mTitle;
    public LinearLayout mTitlePanel;

    public void onButtonClick(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = 2131690902;
        public static final int DIALOG_POSITIVE_TEXT_OK = 2131690906;
        public static HashMap<String, Builder> sBuilderMap;
        public static ArrayList sDialogList;
        public transient /* synthetic */ FieldHolder $fh;
        public DialogInterface.OnCancelListener cancelListener;
        public View contentView;
        public int[] customPanelMarginLayoutParams;
        public DialogInterface.OnDismissListener dismissListener;
        public Bundle extras;
        public String from;
        public boolean hideBtnsPanel;
        public boolean hideTitle;
        public Drawable icon;
        public Context mContext;
        public Drawable mDialogBackGroundDrawable;
        public Class<? extends Activity> mDialogClass;
        public Drawable mNegativeBackGroundDrawable;
        public Drawable mPositiveBackGroundDrawable;
        public int mScrollViewHeight;
        public Object mTag;
        public CharSequence message;
        public DialogInterface.OnClickListener negativeListener;
        public String negativeText;
        public boolean positiveEnabled;
        public DialogInterface.OnClickListener positiveListener;
        public String positiveText;
        public int positiveTextColor;
        public String title;

        /* loaded from: classes.dex */
        public static class DismissEventObject {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Object tag;

            public DismissEventObject(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.tag = obj;
            }
        }

        /* loaded from: classes.dex */
        public static class EventObject {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public DialogInterface dialog;
            public int which;

            public EventObject(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dialogInterface, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.dialog = dialogInterface;
                this.which = i;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(848777668, "Lcom/baidu/android/ext/widget/dialog/BaseActivityDialog$Builder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(848777668, "Lcom/baidu/android/ext/widget/dialog/BaseActivityDialog$Builder;");
                    return;
                }
            }
            sBuilderMap = new HashMap<>();
            sDialogList = new ArrayList();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder() {
            this(BaseActivityDialog.class);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                sDialogList.remove(this.mTag);
                this.positiveListener = null;
                this.negativeListener = null;
                this.cancelListener = null;
                this.dismissListener = null;
                this.contentView = null;
                this.icon = null;
            }
        }

        public void show() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
                show(false);
            }
        }

        public Builder(Class<? extends Activity> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.positiveEnabled = true;
            this.mScrollViewHeight = -1;
            if (this.mContext == null) {
                this.mContext = AppRuntime.getAppContext();
            }
            this.mDialogClass = cls;
        }

        public static Builder getBuilder(String str) {
            InterceptResult invokeL;
            Builder remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    synchronized (sBuilderMap) {
                        remove = sBuilderMap.remove(str);
                    }
                    return remove;
                }
                return null;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder hideTitle(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.hideTitle = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public boolean isShowing(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return sDialogList.contains(obj);
            }
            return invokeL.booleanValue;
        }

        public void onEvent(EventObject eventObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eventObject) != null) || eventObject == null) {
                return;
            }
            DialogInterface.OnClickListener onClickListener = null;
            int i = eventObject.which;
            if (i != -2) {
                if (i == -1) {
                    onClickListener = this.positiveListener;
                }
            } else {
                onClickListener = this.negativeListener;
            }
            if (onClickListener != null) {
                onClickListener.onClick(eventObject.dialog, eventObject.which);
            }
        }

        public Builder setBundle(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
                this.extras = bundle;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setContext(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
                this.mContext = context;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDialogBackGroundDrawable(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, drawable)) == null) {
                this.mDialogBackGroundDrawable = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFrom(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.from = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public void setHideBtnsPanel(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.hideBtnsPanel = z;
            }
        }

        public Builder setIcon(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                return setIcon(this.mContext.getResources().getDrawable(i));
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessage(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                return setMessage(this.mContext.getString(i));
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMessageHeight(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
                this.mScrollViewHeight = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setNegativeBackGroundDrawable(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, drawable)) == null) {
                this.mNegativeBackGroundDrawable = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, onCancelListener)) == null) {
                this.cancelListener = onCancelListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, onDismissListener)) == null) {
                this.dismissListener = onDismissListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPositiveBackGroundDrawable(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, drawable)) == null) {
                this.mPositiveBackGroundDrawable = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPositiveEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
                this.positiveEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setPositiveTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
                this.positiveTextColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public void setTag(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, obj) == null) {
                this.mTag = obj;
                sDialogList.add(obj);
            }
        }

        public Builder setTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
                return setTitle(this.mContext.getString(i));
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view2)) == null) {
                this.contentView = view2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public void show(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this, z) { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.Builder.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Builder this$0;
                    public final /* synthetic */ boolean val$forNightMode;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$forNightMode = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.this$0.mContext == null) {
                                this.this$0.mContext = AppRuntime.getAppContext();
                            }
                            if (this.this$0.mDialogClass == null) {
                                this.this$0.mDialogClass = BaseActivityDialog.class;
                            }
                            Intent intent = new Intent(this.this$0.mContext, this.this$0.mDialogClass);
                            intent.putExtra(BaseActivityDialog.KEY_NIGHT_MODE, this.val$forNightMode);
                            String valueOf = String.valueOf(intent.hashCode());
                            intent.putExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER", valueOf);
                            if (!TextUtils.isEmpty(this.this$0.from)) {
                                intent.putExtra("BOX_ACTIVITY_DIALOG_FROM", this.this$0.from);
                            }
                            if (this.this$0.extras != null) {
                                intent.putExtras(this.this$0.extras);
                            }
                            Builder.setBuilder(valueOf, this.this$0);
                            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                            try {
                                ActivityUtils.startActivitySafely(this.this$0.mContext, intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        }

        public static void setBuilder(String str, Builder builder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65562, null, str, builder) == null) && !TextUtils.isEmpty(str) && builder != null) {
                synchronized (sBuilderMap) {
                    sBuilderMap.put(str, builder);
                }
            }
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, onClickListener)) == null) {
                return setNegativeButton(this.mContext.getString(i), onClickListener);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, onClickListener)) == null) {
                return setPositiveButton(this.mContext.getString(i), onClickListener);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setCustomPanelMargin(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048582, this, i, i2, i3, i4)) == null) {
                this.customPanelMarginLayoutParams = new int[]{i, i2, i3, i4};
                return this;
            }
            return (Builder) invokeIIII.objValue;
        }

        public Builder setIcon(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, drawable)) == null) {
                this.icon = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMessage(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
                this.message = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitle(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                this.title = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMessage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.message = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, onClickListener)) == null) {
                this.negativeText = str;
                this.negativeListener = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, onClickListener)) == null) {
                this.positiveText = str;
                this.positiveListener = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setView(View view2, int i, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                this.contentView = view2;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }
    }

    public BaseActivityDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.mBuilder != null) {
                BdEventBus.Companion.getDefault().unregister(this.mBuilder);
                this.mBuilder.release();
                this.mBuilder = null;
            }
            setView(null);
        }
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        DialogInterface.OnCancelListener onCancelListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Builder builder = this.mBuilder;
            if (builder != null && (onCancelListener = builder.cancelListener) != null) {
                onCancelListener.onCancel(this);
            }
            finish();
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onDismiss();
            finish();
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Resources skinResources = SkinResourcesRuntime.getSkinResourceContext().getSkinResources();
            if (skinResources != null) {
                return skinResources;
            }
            return super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        DialogInterface.OnCancelListener onCancelListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Builder builder = this.mBuilder;
            if (builder != null && (onCancelListener = builder.cancelListener) != null) {
                onCancelListener.onCancel(this);
            }
            onDismiss();
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            release();
            super.onDestroy();
        }
    }

    public void onDismiss() {
        Builder builder;
        DialogInterface.OnDismissListener onDismissListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (builder = this.mBuilder) != null && (onDismissListener = builder.dismissListener) != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public void hideTitle(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            LinearLayout linearLayout = this.mTitlePanel;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            linearLayout.setVisibility(i);
        }
    }

    public void post(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, runnable) == null) && runnable != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
            this.mHandler.post(runnable);
        }
    }

    public void setBtnsPanlVisible(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && z) {
            this.mBtnPanelLayout.setVisibility(8);
            this.mDivider2.setVisibility(8);
        }
    }

    public void setIcon(Drawable drawable) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) {
            this.mIcon.setImageDrawable(drawable);
            ImageView imageView = this.mIcon;
            if (drawable != null) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void setPositiveEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mPositiveButton.setEnabled(z);
        }
    }

    public void setPositiveTextColor(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && i != 0) {
            this.mPositiveButton.setTextColor(i);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mTitle.setText(str);
        }
    }

    private boolean isValidView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mDialogLayout != null && this.mTitle != null && this.mMessage != null && this.mPositiveButton != null && this.mNegativeButton != null && this.mNeutralButton != null && this.mDivider2 != null && this.mDivider3 != null && this.mDivider4 != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public TextView ifOnlyOneBtnGetIt() {
        InterceptResult invokeV;
        int i;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView2 = this.mPositiveButton;
            if (textView2 != null && textView2.getVisibility() == 0) {
                textView = this.mPositiveButton;
                i = 1;
            } else {
                i = 0;
                textView = null;
            }
            TextView textView3 = this.mNegativeButton;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i++;
                textView = this.mNegativeButton;
            }
            TextView textView4 = this.mNeutralButton;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i++;
                textView = this.mNeutralButton;
            }
            if (i != 1) {
                return null;
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mTitlePanel = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0925b1);
            this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f0908c9);
            this.mMessage = (TextView) findViewById(R.id.obfuscated_res_0x7f0908be);
            this.mMessageContent = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0908bf);
            this.mPositiveButton = (TextView) findViewById(R.id.obfuscated_res_0x7f091d11);
            this.mNegativeButton = (TextView) findViewById(R.id.obfuscated_res_0x7f091913);
            this.mNeutralButton = (TextView) findViewById(R.id.obfuscated_res_0x7f091928);
            this.mDivider3 = findViewById(R.id.obfuscated_res_0x7f0908fd);
            this.mDivider4 = findViewById(R.id.obfuscated_res_0x7f0908fe);
            this.mDialogContent = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0908b4);
            this.mIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f0908b8);
            this.mDialogLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09214a);
            this.mDivider2 = findViewById(R.id.obfuscated_res_0x7f0908fc);
            this.mScrollView = (BoxScrollView) findViewById(R.id.obfuscated_res_0x7f091769);
            this.mBtnPanelLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904df);
            this.mDialogCustomPanel = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0908b3);
            this.mBtnHeight = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d7);
            if (this.mBuilder.mScrollViewHeight > 0) {
                this.mScrollView.getLayoutParams().height = this.mBuilder.mScrollViewHeight;
            }
            if (DeviceUtil.OSInfo.isGingerbread() || DeviceUtil.OSInfo.isGingerbreadmr1()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702dc);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            int d = x.d(this);
            super.onCreate(bundle);
            x.a(this, d);
            setContentView(R.layout.obfuscated_res_0x7f0d0894);
            getWindow().setLayout(-1, -1);
            Intent intent = getIntent();
            if (intent != null) {
                this.mBuilder = Builder.getBuilder(intent.getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER"));
            }
            if (this.mBuilder == null) {
                finish();
                return;
            }
            BdEventBus.Companion.getDefault().register(this.mBuilder, Builder.EventObject.class, new Action<Builder.EventObject>(this) { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivityDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.bdeventbus.Action
                public void call(Builder.EventObject eventObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, eventObject) == null) {
                        this.this$0.mBuilder.onEvent(eventObject);
                    }
                }
            });
            BdEventBus.Companion.getDefault().register(this.mBuilder, Builder.DismissEventObject.class, new Action<Builder.DismissEventObject>(this) { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivityDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.bdeventbus.Action
                public void call(Builder.DismissEventObject dismissEventObject) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, dismissEventObject) == null) && dismissEventObject.tag == this.this$0.mBuilder.mTag) {
                        this.this$0.dismiss();
                    }
                }
            });
            initViews();
            show();
            setupViews();
        }
    }

    public void setMessage(CharSequence charSequence) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, charSequence) == null) {
            this.mMessage.setText(charSequence);
            LinearLayout linearLayout = this.mMessageContent;
            if (!TextUtils.isEmpty(charSequence)) {
                i = 0;
            } else {
                i = 8;
            }
            linearLayout.setVisibility(i);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0908bf);
            this.mBtnPanelLayout.setLayoutParams(layoutParams);
        }
    }

    public void setView(View view2) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, view2) == null) && (frameLayout = this.mDialogContent) != null) {
            frameLayout.removeAllViews();
            if (view2 != null) {
                this.mDialogContent.addView(view2);
                this.mMessageContent.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0908b3);
                this.mBtnPanelLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public void setNegativeButton(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mNegativeButton.setText(str);
            this.mNegativeButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivityDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.onButtonClick(-2);
                        this.this$0.dismiss();
                        BdEventBus.Companion.getDefault().post(new Builder.EventObject(this.this$0, -2));
                    }
                }
            });
            if (TextUtils.isEmpty(str)) {
                this.mNegativeButton.setVisibility(8);
                if (this.mPositiveButton.getVisibility() == 0) {
                    this.mDivider3.setVisibility(8);
                    return;
                }
                return;
            }
            this.mNegativeButton.setVisibility(0);
            if (this.mPositiveButton.getVisibility() == 0) {
                this.mDivider3.setVisibility(0);
            }
        }
    }

    public void setPositiveButton(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mPositiveButton.setText(str);
            this.mPositiveButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.ext.widget.dialog.BaseActivityDialog.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivityDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.onButtonClick(-1);
                        BdEventBus.Companion.getDefault().post(new Builder.EventObject(this.this$0, -1));
                        this.this$0.dismiss();
                    }
                }
            });
            if (TextUtils.isEmpty(str)) {
                this.mPositiveButton.setVisibility(8);
                if (this.mNegativeButton.getVisibility() == 0) {
                    this.mDivider3.setVisibility(8);
                    return;
                }
                return;
            }
            this.mPositiveButton.setVisibility(0);
            if (this.mNegativeButton.getVisibility() == 0) {
                this.mDivider3.setVisibility(0);
            }
        }
    }

    public void setupViews() {
        Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (builder = this.mBuilder) == null) {
            return;
        }
        setTitle(builder.title);
        setIcon(builder.icon);
        setMessage(builder.message);
        setView(builder.contentView);
        setPositiveEnable(builder.positiveEnabled);
        setPositiveTextColor(builder.positiveTextColor);
        setPositiveButton(builder.positiveText);
        setNegativeButton(builder.negativeText);
        setBtnsPanlVisible(builder.hideBtnsPanel);
        hideTitle(builder.hideTitle);
        if (builder.customPanelMarginLayoutParams != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDialogCustomPanel.getLayoutParams();
            layoutParams.setMargins(builder.customPanelMarginLayoutParams[0], builder.customPanelMarginLayoutParams[1], builder.customPanelMarginLayoutParams[2], builder.customPanelMarginLayoutParams[3]);
            this.mDialogCustomPanel.setLayoutParams(layoutParams);
        }
        if (builder.mDialogBackGroundDrawable != null) {
            this.mDialogLayout.setBackground(builder.mDialogBackGroundDrawable);
        }
        Drawable drawable = builder.mPositiveBackGroundDrawable;
        if (drawable != null) {
            this.mPositiveButton.setBackground(drawable);
        }
        Drawable drawable2 = builder.mNegativeBackGroundDrawable;
        if (drawable2 != null) {
            this.mNegativeButton.setBackground(drawable2);
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Resources resources = getResources();
            if (isValidView() && resources != null) {
                int color = resources.getColor(R.color.obfuscated_res_0x7f06071f);
                int color2 = resources.getColor(R.color.obfuscated_res_0x7f0604c6);
                int color3 = resources.getColor(R.color.obfuscated_res_0x7f06071c);
                this.mDialogLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f080584));
                this.mTitle.setTextColor(color);
                this.mMessage.setTextColor(color2);
                this.mPositiveButton.setTextColor(color);
                this.mPositiveButton.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08020b));
                this.mNegativeButton.setTextColor(color);
                this.mNegativeButton.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08020a));
                this.mNeutralButton.setTextColor(color);
                this.mNeutralButton.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08020c));
                this.mDivider2.setBackgroundColor(color3);
                this.mDivider3.setBackgroundColor(color3);
                this.mDivider4.setBackgroundColor(color3);
                TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
                if (ifOnlyOneBtnGetIt != null) {
                    ifOnlyOneBtnGetIt.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f080209));
                    return;
                }
                return;
            }
            finish();
        }
    }
}
