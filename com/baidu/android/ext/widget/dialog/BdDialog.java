package com.baidu.android.ext.widget.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.dialog.BdDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.skin.ioc.SkinResourcesRuntime;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.CustomLinkMovementMethod;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.x;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u0002:\u000e\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0016J(\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0002J\u0018\u0010=\u001a\u0002062\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010?H\u0002J\u0010\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0007H\u0002J(\u0010B\u001a\u00020-2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u000206H\u0016J\b\u0010D\u001a\u000206H\u0016J\u000e\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007J\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u000206H\u0004J\b\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u000206H\u0016J\u0010\u0010M\u001a\u0002062\u0006\u0010N\u001a\u00020\u0007H\u0004J\u0010\u0010O\u001a\u0002062\u0006\u0010P\u001a\u00020QH\u0016J\u0012\u0010R\u001a\u0002062\b\u0010S\u001a\u0004\u0018\u00010TH\u0014J\b\u0010U\u001a\u000206H\u0014J\b\u0010V\u001a\u000206H\u0016J\b\u0010W\u001a\u000206H\u0004J\u0018\u0010X\u001a\u00020K2\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u0002062\u0006\u0010]\u001a\u00020^H\u0014J\b\u0010_\u001a\u000206H\u0014J\b\u0010`\u001a\u000206H\u0014J\b\u0010a\u001a\u000206H\u0014J\b\u0010b\u001a\u000206H\u0014J\u0012\u0010c\u001a\u0002062\b\u0010d\u001a\u0004\u0018\u00010eH\u0004J\b\u0010f\u001a\u000206H\u0002J\u0018\u0010g\u001a\u0002062\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010?H\u0002J\u001c\u0010h\u001a\u0002062\b\u0010i\u001a\u0004\u0018\u00010j2\b\u0010k\u001a\u0004\u0018\u00010lH\u0004J\u0017\u0010m\u001a\u0002062\b\u0010n\u001a\u0004\u0018\u00010KH\u0002¢\u0006\u0002\u0010oJ\u0012\u0010p\u001a\u0002062\b\u0010q\u001a\u0004\u0018\u00010lH\u0004J5\u0010r\u001a\u0002062\b\u0010s\u001a\u0004\u0018\u00010t2\b\u0010u\u001a\u0004\u0018\u00010K2\b\u0010F\u001a\u0004\u0018\u00010\u00072\b\u0010v\u001a\u0004\u0018\u00010KH\u0004¢\u0006\u0002\u0010wJ\u0012\u0010x\u001a\u0002062\b\u0010y\u001a\u0004\u0018\u00010zH\u0004J\u0012\u0010{\u001a\u0002062\b\u0010|\u001a\u0004\u0018\u00010#H\u0004J\b\u0010}\u001a\u000206H\u0004J\b\u0010~\u001a\u000206H\u0004J\b\u0010\u007f\u001a\u000206H\u0016J\t\u0010\u0080\u0001\u001a\u000206H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006\u0088\u0001"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog;", "Landroid/app/Activity;", "Lcom/baidu/android/ext/widget/dialog/BdDialogInterface;", "()V", "mBottomClose", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "mBreakPoint", "", "mBtnContainer", "Landroid/widget/FrameLayout;", "mBtnHeight", "mBtnItemList", "Ljava/util/ArrayList;", "Lcom/baidu/android/ext/widget/dialog/BdDialog$BottomItem;", "Lkotlin/collections/ArrayList;", "mBuilder", "Lcom/baidu/android/ext/widget/dialog/BdDialog$Builder;", "mDialogContent", "mDialogCustomPanel", "Lcom/baidu/android/ext/widget/dialog/RoundAngleFrameLayout;", "mDialogInterface", "Landroid/content/DialogInterface;", "mDialogLayout", "Landroid/widget/RelativeLayout;", "getMDialogLayout", "()Landroid/widget/RelativeLayout;", "setMDialogLayout", "(Landroid/widget/RelativeLayout;)V", "mDialogLifecycleListener", "Lcom/baidu/android/ext/widget/dialog/BdDialog$IDialogLifecycle;", "<set-?>", "mDialogRootLayout", "getMDialogRootLayout", "()Landroid/widget/FrameLayout;", "mDivider", "Landroid/view/View;", "mHandler", "Landroid/os/Handler;", "mIcon", "Landroid/widget/ImageView;", "mImmersionHelper", "Lcom/baidu/searchbox/widget/ImmersionHelper;", "mMessage", "Landroid/widget/TextView;", "mMessageContent", "Landroid/widget/LinearLayout;", "mRightClose", "mTitle", "mTitlePanel", "getMTitlePanel", "()Landroid/widget/LinearLayout;", "setMTitlePanel", "(Landroid/widget/LinearLayout;)V", "applyImmersion", "", "cancel", "createButton", "item", "parent", "index", "btnsSize", "createButtonItem", "data", "", "createDivider", "orientation", "createStressButton", "dismiss", "finish", "getCompatibleColor", "textColor", "getResources", "Landroid/content/res/Resources;", "initViews", "isCustomViewNoButton", "", "onAttachedToWindow", "onButtonClick", "which", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onDetachedFromWindow", "onDismiss", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onNewIntent", "intent", "Landroid/content/Intent;", MissionEvent.MESSAGE_PAUSE, "onResume", "onStart", MissionEvent.MESSAGE_STOP, CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, "action", "Ljava/lang/Runnable;", "release", "setBtnItemList", "setCloseIconPosition", "closeIconPosition", "Lcom/baidu/android/ext/widget/dialog/BdDialog$CancelXPosition;", "closeDrawable", "Landroid/graphics/drawable/Drawable;", "setHideBotton", "hideBtns", "(Ljava/lang/Boolean;)V", "setIcon", "icon", "setMessage", "message", "", "messageTextBlod", "isMessageTitle", "(Ljava/lang/CharSequence;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "setTitle", "title", "", "setView", "view", "setupViews", "show", "updataMessage", "updataView", "BottomItem", "Builder", "CancelXPosition", "Companion", "IDialogLifecycle", "OnItemClickListener", "ViewHelper", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"BaseActivity"})
/* loaded from: classes.dex */
public final class BdDialog extends Activity implements BdDialogInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_BREAK_POINT = 2;
    public static final float DIALOG_OUTSIDE_BG_ALPHA = 0.5f;
    public static final float DIALOG_OUTSIDE_BG_ALPHA_NIGHT = 0.65f;
    public static final float DIALOG_WITH_SCALE = 0.8f;
    public static final String KEY_FOR_BUILDER = "BOX_ACTIVITY_DIALOG_FOR_BUILDER";
    public static final String KEY_FROM = "BOX_ACTIVITY_DIALOG_FROM";
    public static final int MESSAGE_TEXT_MAX_LINE = 8;
    public static final int MESSAGE_TITLE_TEXT_MAX_LINE = 12;
    public static final int ONE_BUTTON_SIZE = 1;
    public static final String TAG = "BdDialog";
    public static final int THREE_BUTTON_SIZE = 2;
    public static final int TWO_BUTTON_SIZE = 2;
    public static final int TYPE_CANCEL_EVENT = -100;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, View> _$_findViewCache;
    public BdBaseImageView mBottomClose;
    public final int mBreakPoint;
    public FrameLayout mBtnContainer;
    public int mBtnHeight;
    public ArrayList<BottomItem> mBtnItemList;
    public Builder mBuilder;
    public FrameLayout mDialogContent;
    public RoundAngleFrameLayout mDialogCustomPanel;
    public DialogInterface mDialogInterface;
    public RelativeLayout mDialogLayout;
    public IDialogLifecycle mDialogLifecycleListener;
    public FrameLayout mDialogRootLayout;
    public View mDivider;
    public Handler mHandler;
    public ImageView mIcon;
    public ImmersionHelper mImmersionHelper;
    public TextView mMessage;
    public LinearLayout mMessageContent;
    public BdBaseImageView mRightClose;
    public TextView mTitle;
    public LinearLayout mTitlePanel;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog$IDialogLifecycle;", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onNewIntent", "intent", "Landroid/content/Intent;", MissionEvent.MESSAGE_PAUSE, "onResume", "onStart", MissionEvent.MESSAGE_STOP, "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface IDialogLifecycle {
        void onCreate(Bundle bundle);

        void onDestroy();

        void onNewIntent(Intent intent);

        void onPause();

        void onResume();

        void onStart();

        void onStop();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onItemClick(View view2);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1832937050, "Lcom/baidu/android/ext/widget/dialog/BdDialog$WhenMappings;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1832937050, "Lcom/baidu/android/ext/widget/dialog/BdDialog$WhenMappings;");
                    return;
                }
            }
            int[] iArr = new int[CancelXPosition.values().length];
            iArr[CancelXPosition.BOTTOM.ordinal()] = 1;
            iArr[CancelXPosition.TOP_RIGHT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-38505927, "Lcom/baidu/android/ext/widget/dialog/BdDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-38505927, "Lcom/baidu/android/ext/widget/dialog/BdDialog;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public void _$_clearFindViewByIdCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Map<Integer, View> map = this._$_findViewCache;
            View view2 = map.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                if (findViewById != null) {
                    map.put(Integer.valueOf(i), findViewById);
                    return findViewById;
                }
                return null;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public final void onButtonClick(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    @Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 Ç\u00012\u00020\u0001:\u0004Ç\u0001È\u0001B\u0019\b\u0007\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u008b\u0001\u001a\u00020\u00122\u0007\u0010\u008c\u0001\u001a\u00020\u0001J\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0000¢\u0006\u0003\b\u008f\u0001J\u0012\u0010\u0090\u0001\u001a\u00020\u00002\t\u0010\u0091\u0001\u001a\u0004\u0018\u000101J\u0012\u0010\u0092\u0001\u001a\u00020\u00002\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0094\u0001\u001a\u00020\u00002\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010QJ\u001d\u0010\u0094\u0001\u001a\u00020\u00002\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010Q2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010@J\u0019\u0010\u0097\u0001\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0003\u0010\u0098\u0001J\u0012\u0010\u0099\u0001\u001a\u00020\u00002\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010WJ+\u0010\u009b\u0001\u001a\u00020\u00002\u0007\u0010\u009c\u0001\u001a\u00020`2\u0007\u0010\u009d\u0001\u001a\u00020`2\u0007\u0010\u009e\u0001\u001a\u00020`2\u0007\u0010\u009f\u0001\u001a\u00020`J\u0012\u0010 \u0001\u001a\u00020\u00002\t\u0010¡\u0001\u001a\u0004\u0018\u00010@J\u0011\u0010¢\u0001\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u000107J\u0017\u0010£\u0001\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010\u0012¢\u0006\u0003\u0010\u0098\u0001J\u0012\u0010¤\u0001\u001a\u00020\u00002\t\u0010¥\u0001\u001a\u0004\u0018\u00010@J\u0010\u0010¤\u0001\u001a\u00020\u00002\u0007\u0010¦\u0001\u001a\u00020`J\u000f\u0010§\u0001\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0012J\u0012\u0010¨\u0001\u001a\u00020\u00002\t\u0010©\u0001\u001a\u0004\u0018\u00010%J\u0012\u0010ª\u0001\u001a\u00020\u00002\t\u0010«\u0001\u001a\u0004\u0018\u00010nJ\u0010\u0010ª\u0001\u001a\u00020\u00002\u0007\u0010¬\u0001\u001a\u00020`J\u0012\u0010ª\u0001\u001a\u00020\u00002\t\u0010«\u0001\u001a\u0004\u0018\u000107J\u0018\u0010\u00ad\u0001\u001a\u00020\u00002\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0003\u0010\u0098\u0001J\u0010\u0010¯\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u00020`J\u0010\u0010±\u0001\u001a\u00020\u00002\u0007\u0010²\u0001\u001a\u00020`J\u0017\u0010³\u0001\u001a\u00020\u00002\b\u0010J\u001a\u0004\u0018\u00010\u0012¢\u0006\u0003\u0010\u0098\u0001J\u0011\u0010´\u0001\u001a\u00020\u00002\b\u0010µ\u0001\u001a\u00030¶\u0001J\u0010\u0010·\u0001\u001a\u00020\u00002\u0007\u0010©\u0001\u001a\u00020\fJ\u0012\u0010¸\u0001\u001a\u00020\u00002\t\u0010©\u0001\u001a\u0004\u0018\u00010+J\u0012\u0010¹\u0001\u001a\u00020\u00002\t\u0010©\u0001\u001a\u0004\u0018\u00010}J\u0013\u0010º\u0001\u001a\u00030\u008e\u00012\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0001J\u0010\u0010»\u0001\u001a\u00020\u00002\u0007\u0010¼\u0001\u001a\u00020`J\u0012\u0010»\u0001\u001a\u00020\u00002\t\u0010«\u0001\u001a\u0004\u0018\u000107J\u0010\u0010½\u0001\u001a\u00020\u00002\u0007\u0010¾\u0001\u001a\u00020`J\u0012\u0010¿\u0001\u001a\u00020\u00002\t\u0010À\u0001\u001a\u0004\u0018\u00010\u0019J6\u0010¿\u0001\u001a\u00020\u00002\t\u0010À\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010Á\u0001\u001a\u00020`2\u0007\u0010Â\u0001\u001a\u00020`2\u0007\u0010Ã\u0001\u001a\u00020`2\u0007\u0010Ä\u0001\u001a\u00020`J\u0013\u0010Å\u0001\u001a\u00020\u00002\n\u0010©\u0001\u001a\u0005\u0018\u00010\u0083\u0001J\b\u0010Æ\u0001\u001a\u00030\u008e\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b=\u0010\u0014\"\u0004\b>\u0010\u0016R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010G\"\u0004\bL\u0010IR\u001c\u0010M\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010B\"\u0004\bO\u0010DR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010B\"\u0004\b^\u0010DR\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020`X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010e\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020`X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010b\"\u0004\bl\u0010dR\u001c\u0010m\u001a\u0004\u0018\u00010nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001a\u0010s\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010G\"\u0004\bu\u0010IR\u001e\u0010v\u001a\u0004\u0018\u00010`X\u0080\u000e¢\u0006\u0010\n\u0002\u0010{\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001e\u0010|\u001a\u0004\u0018\u00010}X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\"\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001f\u0010\u0088\u0001\u001a\u0004\u0018\u000107X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u00109\"\u0005\b\u008a\u0001\u0010;¨\u0006É\u0001"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog$Builder;", "", "mDialogClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "(Ljava/lang/Class;)V", "btnList", "", "Lcom/baidu/android/ext/widget/dialog/BdDialog$BottomItem;", "getBtnList$lib_dialog_release", "()Ljava/util/List;", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getCancelListener$lib_dialog_release", "()Landroid/content/DialogInterface$OnCancelListener;", "setCancelListener$lib_dialog_release", "(Landroid/content/DialogInterface$OnCancelListener;)V", "cancelOutside", "", "getCancelOutside$lib_dialog_release", "()Ljava/lang/Boolean;", "setCancelOutside$lib_dialog_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "contentView", "Landroid/view/View;", "getContentView$lib_dialog_release", "()Landroid/view/View;", "setContentView$lib_dialog_release", "(Landroid/view/View;)V", "customPanelMarginLayoutParams", "", "getCustomPanelMarginLayoutParams$lib_dialog_release", "()[I", "setCustomPanelMarginLayoutParams$lib_dialog_release", "([I)V", "dialogLifecycleListener", "Lcom/baidu/android/ext/widget/dialog/BdDialog$IDialogLifecycle;", "getDialogLifecycleListener$lib_dialog_release", "()Lcom/baidu/android/ext/widget/dialog/BdDialog$IDialogLifecycle;", "setDialogLifecycleListener$lib_dialog_release", "(Lcom/baidu/android/ext/widget/dialog/BdDialog$IDialogLifecycle;)V", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener$lib_dialog_release", "()Landroid/content/DialogInterface$OnDismissListener;", "setDismissListener$lib_dialog_release", "(Landroid/content/DialogInterface$OnDismissListener;)V", "extras", "Landroid/os/Bundle;", "getExtras$lib_dialog_release", "()Landroid/os/Bundle;", "setExtras$lib_dialog_release", "(Landroid/os/Bundle;)V", "from", "", "getFrom$lib_dialog_release", "()Ljava/lang/String;", "setFrom$lib_dialog_release", "(Ljava/lang/String;)V", "hideBtns", "getHideBtns$lib_dialog_release", "setHideBtns$lib_dialog_release", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon$lib_dialog_release", "()Landroid/graphics/drawable/Drawable;", "setIcon$lib_dialog_release", "(Landroid/graphics/drawable/Drawable;)V", "interceptOnKeyListener", "getInterceptOnKeyListener$lib_dialog_release", "()Z", "setInterceptOnKeyListener$lib_dialog_release", "(Z)V", "isMessageTitle", "isMessageTitle$lib_dialog_release", "setMessageTitle$lib_dialog_release", "mCancelXDrawable", "getMCancelXDrawable$lib_dialog_release", "setMCancelXDrawable$lib_dialog_release", "mCancelXPosition", "Lcom/baidu/android/ext/widget/dialog/BdDialog$CancelXPosition;", "getMCancelXPosition$lib_dialog_release", "()Lcom/baidu/android/ext/widget/dialog/BdDialog$CancelXPosition;", "setMCancelXPosition$lib_dialog_release", "(Lcom/baidu/android/ext/widget/dialog/BdDialog$CancelXPosition;)V", "mContext", "Landroid/content/Context;", "getMContext$lib_dialog_release", "()Landroid/content/Context;", "setMContext$lib_dialog_release", "(Landroid/content/Context;)V", "mDialogBackGroundDrawable", "getMDialogBackGroundDrawable$lib_dialog_release", "setMDialogBackGroundDrawable$lib_dialog_release", "mMessageMaxLine", "", "getMMessageMaxLine$lib_dialog_release", "()I", "setMMessageMaxLine$lib_dialog_release", "(I)V", "mTag", "getMTag$lib_dialog_release", "()Ljava/lang/Object;", "setMTag$lib_dialog_release", "(Ljava/lang/Object;)V", "mTopRightCancelXMarginRight", "getMTopRightCancelXMarginRight$lib_dialog_release", "setMTopRightCancelXMarginRight$lib_dialog_release", "message", "", "getMessage$lib_dialog_release", "()Ljava/lang/CharSequence;", "setMessage$lib_dialog_release", "(Ljava/lang/CharSequence;)V", "messageTextBlod", "getMessageTextBlod$lib_dialog_release", "setMessageTextBlod$lib_dialog_release", "messageTextColor", "getMessageTextColor$lib_dialog_release", "()Ljava/lang/Integer;", "setMessageTextColor$lib_dialog_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "onKeyListener", "Landroid/content/DialogInterface$OnKeyListener;", "getOnKeyListener$lib_dialog_release", "()Landroid/content/DialogInterface$OnKeyListener;", "setOnKeyListener$lib_dialog_release", "(Landroid/content/DialogInterface$OnKeyListener;)V", "onShowListener", "Landroid/content/DialogInterface$OnShowListener;", "getOnShowListener$lib_dialog_release", "()Landroid/content/DialogInterface$OnShowListener;", "setOnShowListener$lib_dialog_release", "(Landroid/content/DialogInterface$OnShowListener;)V", "title", "getTitle$lib_dialog_release", "setTitle$lib_dialog_release", "isShowing", "tag", "release", "", "release$lib_dialog_release", "setBundle", StateManager.KEY_STATE, "setButton", "item", "setCancelXPosition", "cancelXPosition", "cancelXDrawable", "setCancelableOutside", "(Ljava/lang/Boolean;)Lcom/baidu/android/ext/widget/dialog/BdDialog$Builder;", "setContext", "context", "setCustomPanelMargin", "left", "top", "right", "bottom", "setDialogBackGroundDrawable", "dialogBackGroundDrawable", "setFrom", "setHideBtns", "setIcon", ResourceManager.DRAWABLE, "iconId", "setInterceptOnKeyListener", "setLifecycleListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setMessage", "text", MiPushMessage.KEY_MESSAGE_ID, "setMessageBlod", "isBlod", "setMessageMaxLine", "maxLine", "setMessageTextColor", "textColor", "setMessageTitle", "setMsgClickSpan", "clickInfo", "Lcom/baidu/android/ext/widget/dialog/ClickSpanInfo;", "setOnCancelListener", "setOnDismissListener", "setOnKeyListener", "setTag", "setTitle", "titleId", "setTopRightCancelXMarginRight", "topRightCancelXMarginRight", "setView", "view", "viewSpacingLeft", "viewSpacingTop", "viewSpacingRight", "viewSpacingBottom", "setonShowListener", "show", "Companion", "EventObject", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public static final Companion Companion;
        public static final HashMap<String, Builder> sBuilderMap;
        public static final ArrayList<Object> sDialogList;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<BottomItem> btnList;
        public DialogInterface.OnCancelListener cancelListener;
        public Boolean cancelOutside;
        public View contentView;
        public int[] customPanelMarginLayoutParams;
        public IDialogLifecycle dialogLifecycleListener;
        public DialogInterface.OnDismissListener dismissListener;
        public Bundle extras;
        public String from;
        public Boolean hideBtns;
        public Drawable icon;
        public boolean interceptOnKeyListener;
        public boolean isMessageTitle;
        public Drawable mCancelXDrawable;
        public CancelXPosition mCancelXPosition;
        public Context mContext;
        public Drawable mDialogBackGroundDrawable;
        public Class<? extends Activity> mDialogClass;
        public int mMessageMaxLine;
        public Object mTag;
        public int mTopRightCancelXMarginRight;
        public CharSequence message;
        public boolean messageTextBlod;
        public Integer messageTextColor;
        public DialogInterface.OnKeyListener onKeyListener;
        public DialogInterface.OnShowListener onShowListener;
        public String title;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Builder() {
            this(null, 1, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((Class) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\rJ\u001f\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0011R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog$Builder$Companion;", "", "()V", "sBuilderMap", "Ljava/util/HashMap;", "", "Lcom/baidu/android/ext/widget/dialog/BdDialog$Builder;", "Lkotlin/collections/HashMap;", "sDialogList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getBuilder", "key", "getBuilder$lib_dialog_release", "setBuilder", "", "builder", "setBuilder$lib_dialog_release", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public Companion() {
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

            public final Builder getBuilder$lib_dialog_release(String key) {
                InterceptResult invokeL;
                Builder builder;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, key)) == null) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    if (!TextUtils.isEmpty(key)) {
                        synchronized (Builder.sBuilderMap) {
                            builder = (Builder) Builder.sBuilderMap.remove(key);
                        }
                        return builder;
                    }
                    return null;
                }
                return (Builder) invokeL.objValue;
            }

            public final void setBuilder$lib_dialog_release(String key, Builder builder) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, key, builder) == null) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    if (TextUtils.isEmpty(key) || builder == null) {
                        return;
                    }
                    synchronized (Builder.sBuilderMap) {
                        Builder builder2 = (Builder) Builder.sBuilderMap.put(key, builder);
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog$Builder$EventObject;", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "(Landroid/content/DialogInterface;I)V", "getWhich", "()I", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class EventObject {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final DialogInterface dialog;
            public final int which;

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

            public final int getWhich() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.which;
                }
                return invokeV.intValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-489842622, "Lcom/baidu/android/ext/widget/dialog/BdDialog$Builder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-489842622, "Lcom/baidu/android/ext/widget/dialog/BdDialog$Builder;");
                    return;
                }
            }
            Companion = new Companion(null);
            sBuilderMap = new HashMap<>();
            sDialogList = new ArrayList<>();
        }

        @JvmOverloads
        public Builder(Class<? extends Activity> mDialogClass) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mDialogClass};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(mDialogClass, "mDialogClass");
            this.mDialogClass = mDialogClass;
            this.mMessageMaxLine = -1;
            Boolean bool = Boolean.FALSE;
            this.hideBtns = bool;
            this.cancelOutside = bool;
            this.btnList = new ArrayList();
            this.mTopRightCancelXMarginRight = -1;
            if (this.mContext == null) {
                this.mContext = AppRuntime.getAppContext();
            }
        }

        public /* synthetic */ Builder(Class cls, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? BdDialog.class : cls);
        }

        public final List<BottomItem> getBtnList$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.btnList;
            }
            return (List) invokeV.objValue;
        }

        public final DialogInterface.OnCancelListener getCancelListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.cancelListener;
            }
            return (DialogInterface.OnCancelListener) invokeV.objValue;
        }

        public final Boolean getCancelOutside$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.cancelOutside;
            }
            return (Boolean) invokeV.objValue;
        }

        public final View getContentView$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.contentView;
            }
            return (View) invokeV.objValue;
        }

        public final int[] getCustomPanelMarginLayoutParams$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.customPanelMarginLayoutParams;
            }
            return (int[]) invokeV.objValue;
        }

        public final IDialogLifecycle getDialogLifecycleListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.dialogLifecycleListener;
            }
            return (IDialogLifecycle) invokeV.objValue;
        }

        public final DialogInterface.OnDismissListener getDismissListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.dismissListener;
            }
            return (DialogInterface.OnDismissListener) invokeV.objValue;
        }

        public final Bundle getExtras$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.extras;
            }
            return (Bundle) invokeV.objValue;
        }

        public final String getFrom$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.from;
            }
            return (String) invokeV.objValue;
        }

        public final Boolean getHideBtns$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.hideBtns;
            }
            return (Boolean) invokeV.objValue;
        }

        public final Drawable getIcon$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.icon;
            }
            return (Drawable) invokeV.objValue;
        }

        public final boolean getInterceptOnKeyListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.interceptOnKeyListener;
            }
            return invokeV.booleanValue;
        }

        public final Drawable getMCancelXDrawable$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.mCancelXDrawable;
            }
            return (Drawable) invokeV.objValue;
        }

        public final CancelXPosition getMCancelXPosition$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.mCancelXPosition;
            }
            return (CancelXPosition) invokeV.objValue;
        }

        public final Context getMContext$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.mContext;
            }
            return (Context) invokeV.objValue;
        }

        public final Drawable getMDialogBackGroundDrawable$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.mDialogBackGroundDrawable;
            }
            return (Drawable) invokeV.objValue;
        }

        public final int getMMessageMaxLine$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.mMessageMaxLine;
            }
            return invokeV.intValue;
        }

        public final Object getMTag$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.mTag;
            }
            return invokeV.objValue;
        }

        public final int getMTopRightCancelXMarginRight$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.mTopRightCancelXMarginRight;
            }
            return invokeV.intValue;
        }

        public final CharSequence getMessage$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.message;
            }
            return (CharSequence) invokeV.objValue;
        }

        public final boolean getMessageTextBlod$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.messageTextBlod;
            }
            return invokeV.booleanValue;
        }

        public final Integer getMessageTextColor$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.messageTextColor;
            }
            return (Integer) invokeV.objValue;
        }

        public final DialogInterface.OnKeyListener getOnKeyListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.onKeyListener;
            }
            return (DialogInterface.OnKeyListener) invokeV.objValue;
        }

        public final DialogInterface.OnShowListener getOnShowListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.onShowListener;
            }
            return (DialogInterface.OnShowListener) invokeV.objValue;
        }

        public final String getTitle$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public final boolean isMessageTitle$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.isMessageTitle;
            }
            return invokeV.booleanValue;
        }

        public final void release$lib_dialog_release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
                sDialogList.remove(this.mTag);
                this.dismissListener = null;
                this.onShowListener = null;
                this.dialogLifecycleListener = null;
                this.contentView = null;
                this.icon = null;
                this.mCancelXDrawable = null;
                this.mCancelXPosition = null;
            }
        }

        public final void show() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.do
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BdDialog.Builder.m38show$lambda0(BdDialog.Builder.this);
                        }
                    }
                });
            }
        }

        private final Builder setCancelableOutside(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, bool)) == null) {
                this.cancelOutside = bool;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final boolean isShowing(Object tag) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, tag)) == null) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                return sDialogList.contains(tag);
            }
            return invokeL.booleanValue;
        }

        public final Builder setBundle(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, bundle)) == null) {
                this.extras = bundle;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setButton(BottomItem bottomItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, bottomItem)) == null) {
                if (bottomItem != null) {
                    this.btnList.add(bottomItem);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setCancelListener$lib_dialog_release(DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048606, this, onCancelListener) == null) {
                this.cancelListener = onCancelListener;
            }
        }

        public final void setCancelOutside$lib_dialog_release(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048607, this, bool) == null) {
                this.cancelOutside = bool;
            }
        }

        public final Builder setCancelXPosition(CancelXPosition cancelXPosition) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, cancelXPosition)) == null) {
                this.mCancelXPosition = cancelXPosition;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setContentView$lib_dialog_release(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
                this.contentView = view2;
            }
        }

        public final Builder setContext(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, context)) == null) {
                this.mContext = context;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setCustomPanelMarginLayoutParams$lib_dialog_release(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048613, this, iArr) == null) {
                this.customPanelMarginLayoutParams = iArr;
            }
        }

        public final Builder setDialogBackGroundDrawable(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, drawable)) == null) {
                this.mDialogBackGroundDrawable = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setDialogLifecycleListener$lib_dialog_release(IDialogLifecycle iDialogLifecycle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048615, this, iDialogLifecycle) == null) {
                this.dialogLifecycleListener = iDialogLifecycle;
            }
        }

        public final void setDismissListener$lib_dialog_release(DialogInterface.OnDismissListener onDismissListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048616, this, onDismissListener) == null) {
                this.dismissListener = onDismissListener;
            }
        }

        public final void setExtras$lib_dialog_release(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048617, this, bundle) == null) {
                this.extras = bundle;
            }
        }

        public final Builder setFrom(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
                this.from = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setFrom$lib_dialog_release(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
                this.from = str;
            }
        }

        public final Builder setHideBtns(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, bool)) == null) {
                if (bool != null) {
                    this.hideBtns = bool;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setHideBtns$lib_dialog_release(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048621, this, bool) == null) {
                this.hideBtns = bool;
            }
        }

        public final Builder setIcon(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                return setIcon(ResourcesCompat.getDrawable(context.getResources(), i, null));
            }
            return (Builder) invokeI.objValue;
        }

        public final void setIcon$lib_dialog_release(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048624, this, drawable) == null) {
                this.icon = drawable;
            }
        }

        public final Builder setInterceptOnKeyListener(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
                this.interceptOnKeyListener = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final void setInterceptOnKeyListener$lib_dialog_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
                this.interceptOnKeyListener = z;
            }
        }

        public final Builder setLifecycleListener(IDialogLifecycle iDialogLifecycle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, iDialogLifecycle)) == null) {
                this.dialogLifecycleListener = iDialogLifecycle;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setMCancelXDrawable$lib_dialog_release(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048628, this, drawable) == null) {
                this.mCancelXDrawable = drawable;
            }
        }

        public final void setMCancelXPosition$lib_dialog_release(CancelXPosition cancelXPosition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048629, this, cancelXPosition) == null) {
                this.mCancelXPosition = cancelXPosition;
            }
        }

        public final void setMContext$lib_dialog_release(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048630, this, context) == null) {
                this.mContext = context;
            }
        }

        public final void setMDialogBackGroundDrawable$lib_dialog_release(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048631, this, drawable) == null) {
                this.mDialogBackGroundDrawable = drawable;
            }
        }

        public final void setMMessageMaxLine$lib_dialog_release(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
                this.mMessageMaxLine = i;
            }
        }

        public final void setMTag$lib_dialog_release(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048633, this, obj) == null) {
                this.mTag = obj;
            }
        }

        public final void setMTopRightCancelXMarginRight$lib_dialog_release(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
                this.mTopRightCancelXMarginRight = i;
            }
        }

        public final Builder setMessage(int i) {
            InterceptResult invokeI;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i)) == null) {
                Context context = this.mContext;
                if (context != null) {
                    str = context.getString(i);
                } else {
                    str = null;
                }
                return setMessage(str);
            }
            return (Builder) invokeI.objValue;
        }

        public final void setMessage$lib_dialog_release(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048638, this, charSequence) == null) {
                this.message = charSequence;
            }
        }

        public final Builder setMessageBlod(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, bool)) == null) {
                if (bool != null) {
                    this.messageTextBlod = bool.booleanValue();
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setMessageMaxLine(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i)) == null) {
                this.mMessageMaxLine = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final void setMessageTextBlod$lib_dialog_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
                this.messageTextBlod = z;
            }
        }

        public final Builder setMessageTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) {
                this.messageTextColor = Integer.valueOf(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final void setMessageTextColor$lib_dialog_release(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048643, this, num) == null) {
                this.messageTextColor = num;
            }
        }

        public final Builder setMessageTitle(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, bool)) == null) {
                if (bool != null) {
                    this.isMessageTitle = bool.booleanValue();
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setMessageTitle$lib_dialog_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
                this.isMessageTitle = z;
            }
        }

        public final Builder setOnCancelListener(DialogInterface.OnCancelListener listener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, listener)) == null) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                this.cancelListener = listener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, onDismissListener)) == null) {
                this.dismissListener = onDismissListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, onKeyListener)) == null) {
                this.onKeyListener = onKeyListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setOnKeyListener$lib_dialog_release(DialogInterface.OnKeyListener onKeyListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048650, this, onKeyListener) == null) {
                this.onKeyListener = onKeyListener;
            }
        }

        public final void setOnShowListener$lib_dialog_release(DialogInterface.OnShowListener onShowListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048651, this, onShowListener) == null) {
                this.onShowListener = onShowListener;
            }
        }

        public final void setTag(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048652, this, obj) == null) {
                this.mTag = obj;
                sDialogList.add(obj);
            }
        }

        public final Builder setTitle(int i) {
            InterceptResult invokeI;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048653, this, i)) == null) {
                Context context = this.mContext;
                if (context != null) {
                    str = context.getString(i);
                } else {
                    str = null;
                }
                return setTitle(str);
            }
            return (Builder) invokeI.objValue;
        }

        public final void setTitle$lib_dialog_release(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
                this.title = str;
            }
        }

        public final Builder setTopRightCancelXMarginRight(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048656, this, i)) == null) {
                this.mTopRightCancelXMarginRight = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder setView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, view2)) == null) {
                this.contentView = view2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setonShowListener(DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, onShowListener)) == null) {
                this.onShowListener = onShowListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        /* renamed from: show$lambda-0  reason: not valid java name */
        public static final void m38show$lambda0(Builder this$0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (this$0.mContext == null) {
                    this$0.mContext = AppRuntime.getAppContext();
                }
                if (this$0.mDialogClass == null) {
                    this$0.mDialogClass = BdDialog.class;
                }
                Intent intent = new Intent(AppRuntime.getAppContext(), this$0.mDialogClass);
                String valueOf = String.valueOf(intent.hashCode());
                intent.putExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER", valueOf);
                if (!TextUtils.isEmpty(this$0.from)) {
                    intent.putExtra("BOX_ACTIVITY_DIALOG_FROM", this$0.from);
                }
                Bundle bundle = this$0.extras;
                if (bundle != null) {
                    Intrinsics.checkNotNull(bundle);
                    intent.putExtras(bundle);
                }
                Companion.setBuilder$lib_dialog_release(valueOf, this$0);
                if (!(this$0.mContext instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                try {
                    ActivityUtils.startActivitySafely(this$0.mContext, intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public final Builder setCancelXPosition(CancelXPosition cancelXPosition, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, cancelXPosition, drawable)) == null) {
                this.mCancelXPosition = cancelXPosition;
                this.mCancelXDrawable = drawable;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public final Builder setCustomPanelMargin(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048612, this, i, i2, i3, i4)) == null) {
                this.customPanelMarginLayoutParams = new int[]{i, i2, i3, i4};
                return this;
            }
            return (Builder) invokeIIII.objValue;
        }

        public final Builder setIcon(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, drawable)) == null) {
                this.icon = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setMessage(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, charSequence)) == null) {
                this.message = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setTitle(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, str)) == null) {
                this.title = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setMessage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
                this.message = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setMsgClickSpan(ClickSpanInfo clickInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, clickInfo)) == null) {
                Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
                CharSequence charSequence = this.message;
                if (TextUtils.isEmpty(charSequence)) {
                    return this;
                }
                SpannableString spannableString = new SpannableString(charSequence);
                spannableString.setSpan(clickInfo.getMClickableSpan$lib_dialog_release(), clickInfo.getStart$lib_dialog_release(), clickInfo.getEnd$lib_dialog_release(), clickInfo.getFlag$lib_dialog_release());
                this.message = spannableString;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setView(View view2, int i, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                this.contentView = view2;
                this.customPanelMarginLayoutParams = new int[]{i, i2, i3, i4};
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fBC\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eBK\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0012B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0013B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0014B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0015B9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0017B!\b\u0016\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0018B)\b\u0016\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0019B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001aB)\b\u0016\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001bB1\b\u0016\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001cJ\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CR\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010:\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00101\"\u0004\b<\u00103R\u001e\u0010=\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b>\u00106\"\u0004\b?\u00108¨\u0006D"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog$BottomItem;", "", "text", "", "subText", "textColor", "", "subTextColor", "blodTextStyle", "", "onItemClickListener", "Lcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZLcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "isStressButtonStyle", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZLcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "stressBgId", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZILcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;ILcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;ZILcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;IZILcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;IZLcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;IZZLcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;IZIZLcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;Lcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(ZLjava/lang/CharSequence;Lcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(ZILjava/lang/CharSequence;Lcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;ZLcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(ZLjava/lang/CharSequence;ZLcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "(ZILjava/lang/CharSequence;ZLcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "mBlodTextStyle", "getMBlodTextStyle", "()Z", "setMBlodTextStyle", "(Z)V", "mIsStressButtonStyle", "getMIsStressButtonStyle", "setMIsStressButtonStyle", "mOnItemClickListener", "getMOnItemClickListener", "()Lcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;", "setMOnItemClickListener", "(Lcom/baidu/android/ext/widget/dialog/BdDialog$OnItemClickListener;)V", "mStressBgId", "getMStressBgId", "()I", "setMStressBgId", "(I)V", "mSubText", "getMSubText", "()Ljava/lang/CharSequence;", "setMSubText", "(Ljava/lang/CharSequence;)V", "mSubTextColor", "getMSubTextColor", "()Ljava/lang/Integer;", "setMSubTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mText", "getMText", "setMText", "mTextColor", "getMTextColor", "setMTextColor", "onItemClick", "", "view", "Landroid/view/View;", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class BottomItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mBlodTextStyle;
        public boolean mIsStressButtonStyle;
        public OnItemClickListener mOnItemClickListener;
        public int mStressBgId;
        public CharSequence mSubText;
        public Integer mSubTextColor;
        public CharSequence mText;
        public Integer mTextColor;

        public BottomItem(CharSequence text, int i, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, Integer.valueOf(i), onItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mTextColor = Integer.valueOf(i);
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, int i, boolean z, int i2, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), onItemClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mTextColor = Integer.valueOf(i);
            this.mIsStressButtonStyle = z;
            this.mStressBgId = i2;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, int i, boolean z, int i2, boolean z2, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), onItemClickListener};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mTextColor = Integer.valueOf(i);
            this.mBlodTextStyle = z2;
            this.mIsStressButtonStyle = z;
            this.mStressBgId = i2;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, int i, boolean z, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, Integer.valueOf(i), Boolean.valueOf(z), onItemClickListener};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mTextColor = Integer.valueOf(i);
            this.mBlodTextStyle = z;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, int i, boolean z, boolean z2, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), onItemClickListener};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mTextColor = Integer.valueOf(i);
            this.mBlodTextStyle = z2;
            this.mIsStressButtonStyle = z;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, onItemClickListener};
                interceptable.invokeUnInit(65541, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, CharSequence charSequence, int i, int i2, boolean z, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), onItemClickListener};
                interceptable.invokeUnInit(65542, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65542, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mSubText = charSequence;
            this.mTextColor = Integer.valueOf(i);
            this.mBlodTextStyle = z;
            this.mSubTextColor = Integer.valueOf(i2);
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, CharSequence charSequence, int i, int i2, boolean z, boolean z2, int i3, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3), onItemClickListener};
                interceptable.invokeUnInit(65543, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65543, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mSubText = charSequence;
            this.mTextColor = Integer.valueOf(i);
            this.mBlodTextStyle = z;
            this.mSubTextColor = Integer.valueOf(i2);
            this.mIsStressButtonStyle = z2;
            this.mStressBgId = i3;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, CharSequence charSequence, int i, int i2, boolean z, boolean z2, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), onItemClickListener};
                interceptable.invokeUnInit(65544, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65544, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mSubText = charSequence;
            this.mTextColor = Integer.valueOf(i);
            this.mBlodTextStyle = z;
            this.mSubTextColor = Integer.valueOf(i2);
            this.mIsStressButtonStyle = z2;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, boolean z, int i, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, Boolean.valueOf(z), Integer.valueOf(i), onItemClickListener};
                interceptable.invokeUnInit(65545, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65545, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mTextColor = Integer.valueOf(i);
            this.mIsStressButtonStyle = z;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(CharSequence text, boolean z, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {text, Boolean.valueOf(z), onItemClickListener};
                interceptable.invokeUnInit(65546, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65546, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mBlodTextStyle = z;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(boolean z, int i, CharSequence text, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), text, onItemClickListener};
                interceptable.invokeUnInit(65547, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65547, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mIsStressButtonStyle = z;
            this.mStressBgId = i;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(boolean z, int i, CharSequence text, boolean z2, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), text, Boolean.valueOf(z2), onItemClickListener};
                interceptable.invokeUnInit(65548, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65548, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mBlodTextStyle = z2;
            this.mIsStressButtonStyle = z;
            this.mStressBgId = i;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(boolean z, CharSequence text, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), text, onItemClickListener};
                interceptable.invokeUnInit(65549, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65549, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mIsStressButtonStyle = z;
            this.mOnItemClickListener = onItemClickListener;
        }

        public BottomItem(boolean z, CharSequence text, boolean z2, OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), text, Boolean.valueOf(z2), onItemClickListener};
                interceptable.invokeUnInit(65550, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65550, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(text, "text");
            this.mStressBgId = -1;
            this.mText = text;
            this.mBlodTextStyle = z2;
            this.mIsStressButtonStyle = z;
            this.mOnItemClickListener = onItemClickListener;
        }

        public final boolean getMBlodTextStyle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mBlodTextStyle;
            }
            return invokeV.booleanValue;
        }

        public final boolean getMIsStressButtonStyle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mIsStressButtonStyle;
            }
            return invokeV.booleanValue;
        }

        public final OnItemClickListener getMOnItemClickListener() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mOnItemClickListener;
            }
            return (OnItemClickListener) invokeV.objValue;
        }

        public final int getMStressBgId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mStressBgId;
            }
            return invokeV.intValue;
        }

        public final CharSequence getMSubText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mSubText;
            }
            return (CharSequence) invokeV.objValue;
        }

        public final Integer getMSubTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mSubTextColor;
            }
            return (Integer) invokeV.objValue;
        }

        public final CharSequence getMText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mText;
            }
            return (CharSequence) invokeV.objValue;
        }

        public final Integer getMTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.mTextColor;
            }
            return (Integer) invokeV.objValue;
        }

        public final void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                OnItemClickListener onItemClickListener = this.mOnItemClickListener;
                if (onItemClickListener != null && onItemClickListener != null) {
                    onItemClickListener.onItemClick(view2);
                }
            }
        }

        public final void setMBlodTextStyle(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.mBlodTextStyle = z;
            }
        }

        public final void setMIsStressButtonStyle(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.mIsStressButtonStyle = z;
            }
        }

        public final void setMOnItemClickListener(OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, onItemClickListener) == null) {
                this.mOnItemClickListener = onItemClickListener;
            }
        }

        public final void setMStressBgId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                this.mStressBgId = i;
            }
        }

        public final void setMSubText(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, charSequence) == null) {
                this.mSubText = charSequence;
            }
        }

        public final void setMSubTextColor(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, num) == null) {
                this.mSubTextColor = num;
            }
        }

        public final void setMText(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, charSequence) == null) {
                Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
                this.mText = charSequence;
            }
        }

        public final void setMTextColor(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, num) == null) {
                this.mTextColor = num;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog$CancelXPosition;", "", "(Ljava/lang/String;I)V", "BOTTOM", "TOP_RIGHT", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class CancelXPosition {
        public static final /* synthetic */ CancelXPosition[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CancelXPosition BOTTOM;
        public static final CancelXPosition TOP_RIGHT;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ CancelXPosition[] $values() {
            return new CancelXPosition[]{BOTTOM, TOP_RIGHT};
        }

        public static CancelXPosition valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (CancelXPosition) Enum.valueOf(CancelXPosition.class, str) : (CancelXPosition) invokeL.objValue;
        }

        public static CancelXPosition[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (CancelXPosition[]) $VALUES.clone() : (CancelXPosition[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2140430602, "Lcom/baidu/android/ext/widget/dialog/BdDialog$CancelXPosition;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2140430602, "Lcom/baidu/android/ext/widget/dialog/BdDialog$CancelXPosition;");
                    return;
                }
            }
            BOTTOM = new CancelXPosition("BOTTOM", 0);
            TOP_RIGHT = new CancelXPosition("TOP_RIGHT", 1);
            $VALUES = $values();
        }

        public CancelXPosition(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog$Companion;", "", "()V", "DEBUG", "", "DEFAULT_BREAK_POINT", "", "DIALOG_OUTSIDE_BG_ALPHA", "", "DIALOG_OUTSIDE_BG_ALPHA_NIGHT", "DIALOG_WITH_SCALE", "KEY_FOR_BUILDER", "", "KEY_FROM", "MESSAGE_TEXT_MAX_LINE", "MESSAGE_TITLE_TEXT_MAX_LINE", "ONE_BUTTON_SIZE", "TAG", "THREE_BUTTON_SIZE", "TWO_BUTTON_SIZE", "TYPE_CANCEL_EVENT", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
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
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006!"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdDialog$ViewHelper;", "", "view", "Landroid/view/View;", "dialog", "Lcom/baidu/android/ext/widget/dialog/BdDialog;", "(Lcom/baidu/android/ext/widget/dialog/BdDialog;Landroid/view/View;Lcom/baidu/android/ext/widget/dialog/BdDialog;)V", NativeConstants.ID_BUTTON, "Landroid/widget/LinearLayout;", "getButton$lib_dialog_release", "()Landroid/widget/LinearLayout;", "setButton$lib_dialog_release", "(Landroid/widget/LinearLayout;)V", "mDialog", "getMDialog$lib_dialog_release", "()Lcom/baidu/android/ext/widget/dialog/BdDialog;", "setMDialog$lib_dialog_release", "(Lcom/baidu/android/ext/widget/dialog/BdDialog;)V", "subText", "Landroid/widget/TextView;", "getSubText$lib_dialog_release", "()Landroid/widget/TextView;", "setSubText$lib_dialog_release", "(Landroid/widget/TextView;)V", "text", "getText$lib_dialog_release", "setText$lib_dialog_release", "onBindView", "", "item", "Lcom/baidu/android/ext/widget/dialog/BdDialog$BottomItem;", "index", "", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class ViewHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout button;
        public BdDialog mDialog;
        public TextView subText;
        public TextView text;
        public final /* synthetic */ BdDialog this$0;

        public ViewHelper(BdDialog bdDialog, View view2, BdDialog bdDialog2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdDialog, view2, bdDialog2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdDialog;
            if (view2 != null) {
                this.text = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090377);
                this.subText = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090376);
                this.button = (LinearLayout) view2;
                this.mDialog = bdDialog2;
            }
        }

        /* renamed from: onBindView$lambda-0  reason: not valid java name */
        public static final void m39onBindView$lambda0(BdDialog this$0, int i, BottomItem bottomItem, View view2) {
            OnItemClickListener mOnItemClickListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(65537, null, this$0, i, bottomItem, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                BdEventBus.Companion.getDefault().post(new Builder.EventObject(this$0.mDialogInterface, i));
                if (bottomItem.getMOnItemClickListener() != null && (mOnItemClickListener = bottomItem.getMOnItemClickListener()) != null) {
                    Intrinsics.checkNotNullExpressionValue(view2, "view");
                    mOnItemClickListener.onItemClick(view2);
                }
            }
        }

        public final LinearLayout getButton$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.button;
            }
            return (LinearLayout) invokeV.objValue;
        }

        public final BdDialog getMDialog$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mDialog;
            }
            return (BdDialog) invokeV.objValue;
        }

        public final TextView getSubText$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.subText;
            }
            return (TextView) invokeV.objValue;
        }

        public final TextView getText$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.text;
            }
            return (TextView) invokeV.objValue;
        }

        public final void onBindView(final BottomItem bottomItem, final int i) {
            TextView textView;
            TextView textView2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048580, this, bottomItem, i) != null) || bottomItem == null) {
                return;
            }
            TextView textView3 = this.text;
            if (textView3 != null) {
                textView3.setText(bottomItem.getMText());
            }
            TextView textView4 = this.text;
            if (textView4 != null) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView4, 0, R.dimen.bd_dialog_bd_button_size, 0, 4, null);
            }
            TextView textView5 = this.subText;
            if (textView5 != null) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView5, 0, R.dimen.bd_dialog_bd_sub_button_size, 0, 4, null);
            }
            Integer mTextColor = bottomItem.getMTextColor();
            if (mTextColor != null) {
                TextView textView6 = this.text;
                if (textView6 != null) {
                    textView6.setTextColor(this.this$0.getCompatibleColor(mTextColor.intValue()));
                }
            } else {
                TextView textView7 = this.text;
                if (textView7 != null) {
                    textView7.setTextColor(this.this$0.getResources().getColor(R.color.obfuscated_res_0x7f06036d));
                }
            }
            if (bottomItem.getMBlodTextStyle() && (textView2 = this.text) != null) {
                textView2.setTypeface(Typeface.defaultFromStyle(1));
            }
            if (!TextUtils.isEmpty(bottomItem.getMSubText())) {
                TextView textView8 = this.subText;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
                TextView textView9 = this.subText;
                if (textView9 != null) {
                    textView9.setText(bottomItem.getMSubText());
                }
            } else {
                TextView textView10 = this.subText;
                if (textView10 != null) {
                    textView10.setVisibility(8);
                }
            }
            Integer mSubTextColor = bottomItem.getMSubTextColor();
            if (mSubTextColor != null && (textView = this.subText) != null) {
                textView.setTextColor(this.this$0.getCompatibleColor(mSubTextColor.intValue()));
            }
            LinearLayout linearLayout = this.button;
            if (linearLayout != null) {
                final BdDialog bdDialog = this.this$0;
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sn
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            BdDialog.ViewHelper.m39onBindView$lambda0(BdDialog.this, i, bottomItem, view2);
                        }
                    }
                });
            }
        }

        public final void setButton$lib_dialog_release(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                this.button = linearLayout;
            }
        }

        public final void setMDialog$lib_dialog_release(BdDialog bdDialog) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bdDialog) == null) {
                this.mDialog = bdDialog;
            }
        }

        public final void setSubText$lib_dialog_release(TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
                this.subText = textView;
            }
        }

        public final void setText$lib_dialog_release(TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView) == null) {
                this.text = textView;
            }
        }
    }

    public BdDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this._$_findViewCache = new LinkedHashMap();
        this.mBreakPoint = 2;
        this.mBtnItemList = new ArrayList<>();
    }

    private final void applyImmersion() {
        ImmersionHelper.ImmersionConfig config;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && ImmersionHelper.SUPPORT_IMMERSION) {
            if (this.mImmersionHelper == null) {
                this.mImmersionHelper = new ImmersionHelper(this);
            }
            ImmersionHelper immersionHelper = this.mImmersionHelper;
            if (immersionHelper != null && (config = immersionHelper.getConfig()) != null) {
                config.setIsShowStatusBar(false);
            }
            ImmersionHelper immersionHelper2 = this.mImmersionHelper;
            if (immersionHelper2 != null) {
                immersionHelper2.setImmersion();
            }
        }
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        DialogInterface.OnCancelListener onCancelListener;
        DialogInterface.OnCancelListener cancelListener$lib_dialog_release;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Builder builder = this.mBuilder;
            if (builder != null) {
                if (builder != null) {
                    onCancelListener = builder.getCancelListener$lib_dialog_release();
                } else {
                    onCancelListener = null;
                }
                if (onCancelListener != null) {
                    Builder builder2 = this.mBuilder;
                    if (builder2 != null && (cancelListener$lib_dialog_release = builder2.getCancelListener$lib_dialog_release()) != null) {
                        cancelListener$lib_dialog_release.onCancel(this);
                        return;
                    }
                    return;
                }
            }
            if (!ActivityUtils.isDestroyed(this)) {
                finish();
            }
        }
    }

    private final void setBtnItemList(List<BottomItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, list) == null) {
            this.mBtnItemList.clear();
            if (list != null) {
                this.mBtnItemList.addAll(list);
            }
        }
    }

    private final void setHideBotton(Boolean bool) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, this, bool) == null) && this.mBtnContainer != null && bool != null && bool.booleanValue() && (frameLayout = this.mBtnContainer) != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final int getCompatibleColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            try {
                if (TextUtils.equals(getResources().getResourceTypeName(i), "color")) {
                    return getResources().getColor(i);
                }
                return i;
            } catch (Resources.NotFoundException unused) {
                return i;
            }
        }
        return invokeI.intValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            IDialogLifecycle iDialogLifecycle = this.mDialogLifecycleListener;
            if (iDialogLifecycle != null) {
                iDialogLifecycle.onNewIntent(intent);
            }
        }
    }

    public final void post(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, runnable) == null) && runnable != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    public final void setIcon(Drawable drawable) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, drawable) == null) {
            ImageView imageView = this.mIcon;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
            ImageView imageView2 = this.mIcon;
            if (imageView2 != null) {
                if (drawable != null) {
                    i = 0;
                } else {
                    i = 8;
                }
                imageView2.setVisibility(i);
            }
        }
    }

    public final void setMDialogLayout(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, relativeLayout) == null) {
            this.mDialogLayout = relativeLayout;
        }
    }

    public final void setMTitlePanel(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, linearLayout) == null) {
            this.mTitlePanel = linearLayout;
        }
    }

    private final LinearLayout createButton(BottomItem bottomItem, LinearLayout linearLayout, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65541, this, bottomItem, linearLayout, i, i2)) == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0458, (ViewGroup) linearLayout, false);
            if (inflate != null) {
                LinearLayout linearLayout2 = (LinearLayout) inflate;
                if (i2 == 1) {
                    linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08022f, null), 0, 4, null));
                } else if (i2 == 2) {
                    if (i == 0) {
                        linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080232, null), 0, 4, null));
                    }
                    if (i == 1) {
                        linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080235, null), 0, 4, null));
                    }
                } else if (i2 >= 2) {
                    if (i == i2 - 1) {
                        linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08022f, null), 0, 4, null));
                    } else {
                        linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080238, null), 0, 4, null));
                    }
                }
                new ViewHelper(this, linearLayout2, this).onBindView(bottomItem, i);
                return linearLayout2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        return (LinearLayout) invokeLLII.objValue;
    }

    private final void createButtonItem(List<BottomItem> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, list) == null) && list != null && list.size() > 0) {
            FrameLayout frameLayout = this.mBtnContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            View view2 = this.mDivider;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.mBreakPoint) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null && list.get(i).getMIsStressButtonStyle()) {
                    View view3 = this.mDivider;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                    linearLayout.addView(createStressButton(list.get(i), linearLayout, i, list.size()));
                } else {
                    linearLayout.addView(createButton(list.get(i), linearLayout, i, list.size()));
                    if (i < list.size() - 1) {
                        if (list.size() > this.mBreakPoint) {
                            linearLayout.addView(createDivider(1));
                        } else {
                            linearLayout.addView(createDivider(0));
                        }
                    }
                }
            }
            FrameLayout frameLayout2 = this.mBtnContainer;
            if (frameLayout2 != null) {
                frameLayout2.removeAllViews();
            }
            FrameLayout frameLayout3 = this.mBtnContainer;
            if (frameLayout3 != null) {
                frameLayout3.addView(linearLayout);
            }
        }
    }

    private final View createDivider(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            View view2 = new View(this);
            view2.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06036f));
            if (i == 1) {
                view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            } else {
                view2.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    /* renamed from: onStart$lambda-2  reason: not valid java name */
    public static final void m35onStart$lambda2(BdDialog this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FrameLayout frameLayout = this$0.mDialogRootLayout;
            if (frameLayout != null) {
                int height = frameLayout.getHeight();
                int windowWidth = BdDialogKt.getWindowWidth(this$0);
                if (!this$0.isCustomViewNoButton()) {
                    windowWidth = (int) (windowWidth * 0.8f);
                }
                this$0.getWindow().setLayout(windowWidth, height);
                this$0.getWindow().setGravity(17);
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        int windowWidth;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(newConfig);
            if (isCustomViewNoButton()) {
                windowWidth = -1;
            } else {
                windowWidth = (int) (BdDialogKt.getWindowWidth(this) * 0.8f);
            }
            getWindow().setLayout(windowWidth, -2);
            getWindow().setGravity(17);
        }
    }

    public final void setTitle(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            LinearLayout linearLayout = this.mTitlePanel;
            if (linearLayout != null) {
                if (TextUtils.isEmpty(str)) {
                    i = 8;
                } else {
                    i = 0;
                }
                linearLayout.setVisibility(i);
            }
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setText(str);
            }
            TextView textView2 = this.mTitle;
            if (textView2 != null) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView2, 0, R.dimen.obfuscated_res_0x7f0701ba, 0, 4, null);
            }
        }
    }

    private final LinearLayout createStressButton(final BottomItem bottomItem, LinearLayout linearLayout, final int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65544, this, bottomItem, linearLayout, i, i2)) == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0472, (ViewGroup) linearLayout, false);
            if (inflate != null) {
                LinearLayout linearLayout2 = (LinearLayout) inflate;
                TextView textView = (TextView) linearLayout2.findViewById(R.id.obfuscated_res_0x7f0922c1);
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView, 0, R.dimen.bd_dialog_stress_button_size, 0, 4, null);
                if (i2 == 1) {
                    textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080240, null), 0, 4, null));
                    if (textView != null) {
                        textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060371));
                    }
                } else if (i2 == 2) {
                    if (i == 0) {
                        textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080241, null), 0, 4, null));
                        if (textView != null) {
                            textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060373));
                        }
                        if (linearLayout2.getLayoutParams() != null && (linearLayout2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                            ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
                            if (layoutParams != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                                layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b8);
                                linearLayout2.setLayoutParams(layoutParams2);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                            }
                        }
                    }
                    if (i == 1) {
                        textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080240, null), 0, 4, null));
                        if (textView != null) {
                            textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060371));
                        }
                        if (linearLayout2.getLayoutParams() != null && (linearLayout2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                            ViewGroup.LayoutParams layoutParams3 = linearLayout2.getLayoutParams();
                            if (layoutParams3 != null) {
                                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                                layoutParams4.leftMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b8);
                                linearLayout2.setLayoutParams(layoutParams4);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                            }
                        }
                    }
                } else if (i2 >= 2) {
                    if (i == 0) {
                        textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080240, null), 0, 4, null));
                        if (textView != null) {
                            textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060371));
                        }
                    } else {
                        if (textView != null) {
                            textView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060370));
                        }
                        if (textView != null) {
                            textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06036d));
                        }
                    }
                    if ((i == 0 || i == 1) && textView.getLayoutParams() != null && (textView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        ViewGroup.LayoutParams layoutParams5 = textView.getLayoutParams();
                        if (layoutParams5 != null) {
                            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
                            layoutParams6.bottomMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b7);
                            textView.setLayoutParams(layoutParams6);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        }
                    }
                }
                if (bottomItem.getMStressBgId() != -1) {
                    textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(getResources(), bottomItem.getMStressBgId(), null), 0, 4, null));
                }
                if (textView != null) {
                    textView.setText(bottomItem.getMText());
                }
                Integer mTextColor = bottomItem.getMTextColor();
                if (mTextColor != null && textView != null) {
                    textView.setTextColor(getCompatibleColor(mTextColor.intValue()));
                }
                if (bottomItem.getMBlodTextStyle() && textView != null) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (textView != null) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ao
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                BdDialog.m33createStressButton$lambda6(BdDialog.this, i, bottomItem, view2);
                            }
                        }
                    });
                }
                textView.setOnTouchListener(new TouchStateListener());
                return linearLayout2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        return (LinearLayout) invokeLLII.objValue;
    }

    /* renamed from: createStressButton$lambda-6  reason: not valid java name */
    public static final void m33createStressButton$lambda6(BdDialog this$0, int i, BottomItem item, View view2) {
        OnItemClickListener mOnItemClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65545, null, this$0, i, item, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            BdEventBus.Companion.getDefault().post(new Builder.EventObject(this$0.mDialogInterface, i));
            if (item.getMOnItemClickListener() != null && (mOnItemClickListener = item.getMOnItemClickListener()) != null) {
                Intrinsics.checkNotNullExpressionValue(view2, "view");
                mOnItemClickListener.onItemClick(view2);
            }
        }
    }

    private final boolean isCustomViewNoButton() {
        InterceptResult invokeV;
        View view2;
        List<BottomItem> list;
        List<BottomItem> btnList$lib_dialog_release;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Builder builder = this.mBuilder;
            if (builder != null) {
                Boolean bool = null;
                if (builder != null) {
                    view2 = builder.getContentView$lib_dialog_release();
                } else {
                    view2 = null;
                }
                if (view2 != null) {
                    Builder builder2 = this.mBuilder;
                    if (builder2 != null) {
                        list = builder2.getBtnList$lib_dialog_release();
                    } else {
                        list = null;
                    }
                    if (list != null) {
                        Builder builder3 = this.mBuilder;
                        if (builder3 != null && (btnList$lib_dialog_release = builder3.getBtnList$lib_dialog_release()) != null) {
                            bool = Boolean.valueOf(btnList$lib_dialog_release.isEmpty());
                        }
                        Intrinsics.checkNotNull(bool);
                        if (bool.booleanValue()) {
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.ext.widget.dialog.BdDialogInterface
    public void updataMessage() {
        LinearLayout linearLayout;
        CharSequence charSequence;
        Boolean bool;
        Integer num;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && !ActivityUtils.isDestroyed(this) && this.mBuilder != null && (linearLayout = this.mMessageContent) != null) {
            boolean z = false;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                Builder builder = this.mBuilder;
                Boolean bool2 = null;
                if (builder != null) {
                    charSequence = builder.getMessage$lib_dialog_release();
                } else {
                    charSequence = null;
                }
                Builder builder2 = this.mBuilder;
                if (builder2 != null) {
                    bool = Boolean.valueOf(builder2.getMessageTextBlod$lib_dialog_release());
                } else {
                    bool = null;
                }
                Builder builder3 = this.mBuilder;
                if (builder3 != null) {
                    num = builder3.getMessageTextColor$lib_dialog_release();
                } else {
                    num = null;
                }
                Builder builder4 = this.mBuilder;
                if (builder4 != null) {
                    bool2 = Boolean.valueOf(builder4.isMessageTitle$lib_dialog_release());
                }
                setMessage(charSequence, bool, num, bool2);
            }
        }
    }

    /* renamed from: onAttachedToWindow$lambda-3  reason: not valid java name */
    public static final void m34onAttachedToWindow$lambda3(BdDialog this$0, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, this$0, z) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (NightModeHelper.getNightModeSwitcherState()) {
                this$0.getWindow().setDimAmount(0.65f);
            } else {
                this$0.getWindow().setDimAmount(0.5f);
            }
            this$0.show();
            this$0.setupViews();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent event) {
        InterceptResult invokeIL;
        DialogInterface.OnKeyListener onKeyListener;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            Builder builder = this.mBuilder;
            if (builder != null) {
                onKeyListener = builder.getOnKeyListener$lib_dialog_release();
            } else {
                onKeyListener = null;
            }
            boolean z2 = false;
            if (onKeyListener != null) {
                z = onKeyListener.onKey(this, i, event);
            } else {
                z = false;
            }
            Builder builder2 = this.mBuilder;
            if (builder2 != null) {
                if (builder2 != null && builder2.getInterceptOnKeyListener$lib_dialog_release()) {
                    z2 = true;
                }
                if (z2 && z) {
                    return true;
                }
            }
            return super.onKeyDown(i, event);
        }
        return invokeIL.booleanValue;
    }

    private final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (this.mBuilder != null) {
                BdEventBus bdEventBus = BdEventBus.Companion.getDefault();
                Builder builder = this.mBuilder;
                Intrinsics.checkNotNull(builder);
                bdEventBus.unregister(builder);
                Builder builder2 = this.mBuilder;
                if (builder2 != null) {
                    builder2.release$lib_dialog_release();
                }
                this.mBuilder = null;
            }
            setView(null);
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !ActivityUtils.isDestroyed(this)) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.finish();
            onDismiss();
            overridePendingTransition(R.anim.obfuscated_res_0x7f01009f, R.anim.obfuscated_res_0x7f0100a0);
        }
    }

    public final RelativeLayout getMDialogLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mDialogLayout;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final FrameLayout getMDialogRootLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mDialogRootLayout;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final LinearLayout getMTitlePanel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mTitlePanel;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Resources skinResources = SkinResourcesRuntime.getSkinResourceContext().getSkinResources();
            if (skinResources == null) {
                Resources resources = super.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "super.getResources()");
                return resources;
            }
            return skinResources;
        }
        return (Resources) invokeV.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onAttachedToWindow();
            NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.tieba.un
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
                public final void onNightModeChanged(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        BdDialog.m34onAttachedToWindow$lambda3(BdDialog.this, z);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            IDialogLifecycle iDialogLifecycle = this.mDialogLifecycleListener;
            if (iDialogLifecycle != null) {
                iDialogLifecycle.onDestroy();
            }
            release();
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDetachedFromWindow();
            NightModeHelper.unsubscribeNightModeChangedEvent(this);
        }
    }

    public final void onDismiss() {
        Builder builder;
        DialogInterface.OnDismissListener dismissListener$lib_dialog_release;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (builder = this.mBuilder) != null && (dismissListener$lib_dialog_release = builder.getDismissListener$lib_dialog_release()) != null) {
            dismissListener$lib_dialog_release.onDismiss(this);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPause();
            IDialogLifecycle iDialogLifecycle = this.mDialogLifecycleListener;
            if (iDialogLifecycle != null) {
                iDialogLifecycle.onPause();
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
            IDialogLifecycle iDialogLifecycle = this.mDialogLifecycleListener;
            if (iDialogLifecycle != null) {
                iDialogLifecycle.onResume();
            }
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStart();
            IDialogLifecycle iDialogLifecycle = this.mDialogLifecycleListener;
            if (iDialogLifecycle != null) {
                iDialogLifecycle.onStart();
            }
            if (Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode() && (frameLayout = this.mDialogRootLayout) != null) {
                frameLayout.post(new Runnable() { // from class: com.baidu.tieba.fo
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BdDialog.m35onStart$lambda2(BdDialog.this);
                        }
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onStop();
            IDialogLifecycle iDialogLifecycle = this.mDialogLifecycleListener;
            if (iDialogLifecycle != null) {
                iDialogLifecycle.onStop();
            }
        }
    }

    @Override // com.baidu.android.ext.widget.dialog.BdDialogInterface
    public void updataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            ActivityUtils.isDestroyed(this);
        }
    }

    /* renamed from: setCloseIconPosition$lambda-7  reason: not valid java name */
    public static final void m36setCloseIconPosition$lambda7(BdDialog this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BdEventBus.Companion.getDefault().post(new Builder.EventObject(this$0.mDialogInterface, -100));
        }
    }

    /* renamed from: setCloseIconPosition$lambda-8  reason: not valid java name */
    public static final void m37setCloseIconPosition$lambda8(BdDialog this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BdEventBus.Companion.getDefault().post(new Builder.EventObject(this$0.mDialogInterface, -100));
        }
    }

    public final void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mTitlePanel = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092582);
            this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f0908c4);
            this.mMessage = (TextView) findViewById(R.id.obfuscated_res_0x7f0908b9);
            this.mMessageContent = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0908ba);
            this.mDialogContent = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0908af);
            this.mIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f0908b3);
            this.mDialogRootLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0908c0);
            this.mDialogLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090374);
            this.mDialogCustomPanel = (RoundAngleFrameLayout) findViewById(R.id.obfuscated_res_0x7f0908ae);
            this.mBtnContainer = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090fe4);
            this.mBottomClose = (BdBaseImageView) findViewById(R.id.obfuscated_res_0x7f090456);
            this.mRightClose = (BdBaseImageView) findViewById(R.id.obfuscated_res_0x7f091f1f);
            this.mDivider = findViewById(R.id.obfuscated_res_0x7f090fe8);
            this.mBtnHeight = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d7);
            BdBaseImageView bdBaseImageView = this.mRightClose;
            if (bdBaseImageView != null) {
                FontSizeViewExtKt.setScaledSizeRes$default(bdBaseImageView, 0, R.dimen.bd_dialog_right_close, R.dimen.bd_dialog_right_close, 0, 8, null);
            }
            BdBaseImageView bdBaseImageView2 = this.mBottomClose;
            if (bdBaseImageView2 != null) {
                FontSizeViewExtKt.setScaledSizeRes$default(bdBaseImageView2, 0, R.dimen.bd_dialog_bottom_close, R.dimen.bd_dialog_bottom_close, 0, 8, null);
            }
        }
    }

    public final void setupViews() {
        Builder builder;
        RelativeLayout relativeLayout;
        boolean z;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || (builder = this.mBuilder) == null) {
            return;
        }
        if (builder != null) {
            setBtnItemList(builder.getBtnList$lib_dialog_release());
            setTitle(builder.getTitle$lib_dialog_release());
            setIcon(builder.getIcon$lib_dialog_release());
            setMessage(builder.getMessage$lib_dialog_release(), Boolean.valueOf(builder.getMessageTextBlod$lib_dialog_release()), builder.getMessageTextColor$lib_dialog_release(), Boolean.valueOf(builder.isMessageTitle$lib_dialog_release()));
            setView(builder.getContentView$lib_dialog_release());
            createButtonItem(this.mBtnItemList);
            setHideBotton(builder.getHideBtns$lib_dialog_release());
            setCloseIconPosition(builder.getMCancelXPosition$lib_dialog_release(), builder.getMCancelXDrawable$lib_dialog_release());
            if (builder.getCustomPanelMarginLayoutParams$lib_dialog_release() != null) {
                int[] customPanelMarginLayoutParams$lib_dialog_release = builder.getCustomPanelMarginLayoutParams$lib_dialog_release();
                if (customPanelMarginLayoutParams$lib_dialog_release != null && customPanelMarginLayoutParams$lib_dialog_release.length == 4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    RoundAngleFrameLayout roundAngleFrameLayout = this.mDialogCustomPanel;
                    ViewGroup.LayoutParams layoutParams2 = null;
                    if (roundAngleFrameLayout != null) {
                        layoutParams = roundAngleFrameLayout.getLayoutParams();
                    } else {
                        layoutParams = null;
                    }
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        RoundAngleFrameLayout roundAngleFrameLayout2 = this.mDialogCustomPanel;
                        if (roundAngleFrameLayout2 != null) {
                            layoutParams2 = roundAngleFrameLayout2.getLayoutParams();
                        }
                        if (layoutParams2 != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                            int[] customPanelMarginLayoutParams$lib_dialog_release2 = builder.getCustomPanelMarginLayoutParams$lib_dialog_release();
                            if (customPanelMarginLayoutParams$lib_dialog_release2 != null) {
                                layoutParams3.setMargins(customPanelMarginLayoutParams$lib_dialog_release2[0], customPanelMarginLayoutParams$lib_dialog_release2[1], customPanelMarginLayoutParams$lib_dialog_release2[2], customPanelMarginLayoutParams$lib_dialog_release2[3]);
                            }
                            RoundAngleFrameLayout roundAngleFrameLayout3 = this.mDialogCustomPanel;
                            if (roundAngleFrameLayout3 != null) {
                                roundAngleFrameLayout3.setLayoutParams(layoutParams3);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        }
                    }
                }
            }
            if (builder.getMDialogBackGroundDrawable$lib_dialog_release() != null && (relativeLayout = this.mDialogLayout) != null) {
                relativeLayout.setBackground(builder.getMDialogBackGroundDrawable$lib_dialog_release());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.ext.widget.dialog.BdDialog.Builder");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Boolean bool;
        Boolean bool2;
        DialogInterface.OnShowListener onShowListener$lib_dialog_release;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            int d = x.d(this);
            super.onCreate(bundle);
            x.a(this, d);
            overridePendingTransition(R.anim.obfuscated_res_0x7f01009f, R.anim.obfuscated_res_0x7f0100a0);
            setContentView(R.layout.obfuscated_res_0x7f0d0154);
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            String stringExtra = intent.getStringExtra("BOX_ACTIVITY_DIALOG_FOR_BUILDER");
            Builder.Companion companion = Builder.Companion;
            if (stringExtra == null) {
                stringExtra = "";
            }
            Builder builder$lib_dialog_release = companion.getBuilder$lib_dialog_release(stringExtra);
            this.mBuilder = builder$lib_dialog_release;
            if (builder$lib_dialog_release == null) {
                finish();
                return;
            }
            int windowWidth = BdDialogKt.getWindowWidth(this);
            int i = -1;
            if (isCustomViewNoButton()) {
                getWindow().setLayout((Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) ? -1 : -1, -1);
                getWindow().setGravity(17);
            } else {
                getWindow().setLayout((int) (windowWidth * 0.8f), (Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) ? -2 : -2);
                getWindow().setGravity(17);
            }
            if (NightModeHelper.getNightModeSwitcherState()) {
                getWindow().setDimAmount(0.65f);
            } else {
                getWindow().setDimAmount(0.5f);
            }
            this.mDialogInterface = this;
            Builder builder = this.mBuilder;
            if (builder != null && (onShowListener$lib_dialog_release = builder.getOnShowListener$lib_dialog_release()) != null) {
                onShowListener$lib_dialog_release.onShow(this);
            }
            Builder builder2 = this.mBuilder;
            IDialogLifecycle iDialogLifecycle = null;
            if (builder2 != null) {
                bool = builder2.getCancelOutside$lib_dialog_release();
            } else {
                bool = null;
            }
            if (bool != null) {
                Builder builder3 = this.mBuilder;
                if (builder3 != null) {
                    bool2 = builder3.getCancelOutside$lib_dialog_release();
                } else {
                    bool2 = null;
                }
                Intrinsics.checkNotNull(bool2);
                setFinishOnTouchOutside(bool2.booleanValue());
            }
            Builder builder4 = this.mBuilder;
            if (builder4 != null) {
                iDialogLifecycle = builder4.getDialogLifecycleListener$lib_dialog_release();
            }
            this.mDialogLifecycleListener = iDialogLifecycle;
            if (bundle != null && iDialogLifecycle != null) {
                iDialogLifecycle.onCreate(bundle);
            }
            BdEventBus bdEventBus = BdEventBus.Companion.getDefault();
            Builder builder5 = this.mBuilder;
            Intrinsics.checkNotNull(builder5);
            bdEventBus.register(builder5, Builder.EventObject.class, new Action<Builder.EventObject>(this) { // from class: com.baidu.android.ext.widget.dialog.BdDialog$onCreate$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.bdeventbus.Action
                public void call(BdDialog.Builder.EventObject eventObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, eventObject) == null) {
                        Intrinsics.checkNotNullParameter(eventObject, "eventObject");
                        if (eventObject.getWhich() == -100) {
                            this.this$0.cancel();
                        } else {
                            this.this$0.dismiss();
                        }
                    }
                }
            });
            initViews();
            show();
            setupViews();
        }
    }

    public final void setCloseIconPosition(CancelXPosition cancelXPosition, Drawable drawable) {
        BdBaseImageView bdBaseImageView;
        BdBaseImageView bdBaseImageView2;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, cancelXPosition, drawable) == null) && cancelXPosition != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[cancelXPosition.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    BdBaseImageView bdBaseImageView3 = this.mBottomClose;
                    if (bdBaseImageView3 != null) {
                        bdBaseImageView3.setVisibility(8);
                    }
                    BdBaseImageView bdBaseImageView4 = this.mRightClose;
                    if (bdBaseImageView4 != null) {
                        bdBaseImageView4.setVisibility(0);
                    }
                    Builder builder = this.mBuilder;
                    if (builder != null) {
                        Intrinsics.checkNotNull(builder);
                        if (builder.getMTopRightCancelXMarginRight$lib_dialog_release() > 0) {
                            BdBaseImageView bdBaseImageView5 = this.mRightClose;
                            Integer num = null;
                            if (bdBaseImageView5 != null) {
                                layoutParams = bdBaseImageView5.getLayoutParams();
                            } else {
                                layoutParams = null;
                            }
                            if (layoutParams != null) {
                                BdBaseImageView bdBaseImageView6 = this.mRightClose;
                                if (bdBaseImageView6 != null) {
                                    layoutParams2 = bdBaseImageView6.getLayoutParams();
                                } else {
                                    layoutParams2 = null;
                                }
                                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                                    BdBaseImageView bdBaseImageView7 = this.mRightClose;
                                    if (bdBaseImageView7 != null) {
                                        layoutParams3 = bdBaseImageView7.getLayoutParams();
                                    } else {
                                        layoutParams3 = null;
                                    }
                                    if (layoutParams3 != null) {
                                        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                                        Builder builder2 = this.mBuilder;
                                        if (builder2 != null) {
                                            num = Integer.valueOf(builder2.getMTopRightCancelXMarginRight$lib_dialog_release());
                                        }
                                        Intrinsics.checkNotNull(num);
                                        layoutParams4.rightMargin = num.intValue();
                                        BdBaseImageView bdBaseImageView8 = this.mRightClose;
                                        if (bdBaseImageView8 != null) {
                                            bdBaseImageView8.setLayoutParams(layoutParams4);
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                                    }
                                }
                            }
                        }
                    }
                    if (drawable != null && (bdBaseImageView2 = this.mRightClose) != null) {
                        bdBaseImageView2.setBackground(drawable);
                    }
                    BdBaseImageView bdBaseImageView9 = this.mRightClose;
                    if (bdBaseImageView9 != null) {
                        bdBaseImageView9.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yn
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    BdDialog.m37setCloseIconPosition$lambda8(BdDialog.this, view2);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            BdBaseImageView bdBaseImageView10 = this.mBottomClose;
            if (bdBaseImageView10 != null) {
                bdBaseImageView10.setVisibility(0);
            }
            BdBaseImageView bdBaseImageView11 = this.mRightClose;
            if (bdBaseImageView11 != null) {
                bdBaseImageView11.setVisibility(8);
            }
            BdBaseImageView bdBaseImageView12 = this.mBottomClose;
            if (bdBaseImageView12 != null) {
                bdBaseImageView12.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.eo
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            BdDialog.m36setCloseIconPosition$lambda7(BdDialog.this, view2);
                        }
                    }
                });
            }
            if (drawable != null && (bdBaseImageView = this.mBottomClose) != null) {
                bdBaseImageView.setBackground(drawable);
            }
        }
    }

    public final void setMessage(CharSequence charSequence, Boolean bool, Integer num, Boolean bool2) {
        ViewGroup.LayoutParams layoutParams;
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048605, this, charSequence, bool, num, bool2) == null) {
            TextView textView3 = this.mMessage;
            if (textView3 != null) {
                textView3.setText(charSequence);
            }
            TextView textView4 = this.mMessage;
            if (textView4 != null) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView4, 0, R.dimen.obfuscated_res_0x7f0701b3, 0, 4, null);
            }
            if (bool != null && bool.booleanValue() && (textView2 = this.mMessage) != null) {
                textView2.setTypeface(Typeface.defaultFromStyle(1));
            }
            if (num != null && (textView = this.mMessage) != null) {
                textView.setTextColor(getCompatibleColor(num.intValue()));
            }
            int i = 8;
            if (bool2 != null && bool2.booleanValue()) {
                if (num != null) {
                    TextView textView5 = this.mMessage;
                    if (textView5 != null) {
                        textView5.setTextColor(getCompatibleColor(num.intValue()));
                    }
                } else {
                    TextView textView6 = this.mMessage;
                    if (textView6 != null) {
                        textView6.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06036a));
                    }
                }
                LinearLayout linearLayout = this.mMessageContent;
                ViewGroup.LayoutParams layoutParams2 = null;
                if (linearLayout != null) {
                    layoutParams = linearLayout.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    LinearLayout linearLayout2 = this.mMessageContent;
                    if (linearLayout2 != null) {
                        layoutParams2 = linearLayout2.getLayoutParams();
                    }
                    if (layoutParams2 != null) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                        layoutParams3.topMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b0);
                        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701af);
                        LinearLayout linearLayout3 = this.mMessageContent;
                        if (linearLayout3 != null) {
                            linearLayout3.setLayoutParams(layoutParams3);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    }
                }
                Builder builder = this.mBuilder;
                if (builder != null) {
                    Intrinsics.checkNotNull(builder);
                    if (builder.getMMessageMaxLine$lib_dialog_release() > 0) {
                        TextView textView7 = this.mMessage;
                        if (textView7 != null) {
                            Builder builder2 = this.mBuilder;
                            Intrinsics.checkNotNull(builder2);
                            textView7.setMaxLines(builder2.getMMessageMaxLine$lib_dialog_release());
                        }
                    }
                }
                TextView textView8 = this.mMessage;
                if (textView8 != null) {
                    textView8.setMaxLines(12);
                }
            } else {
                Builder builder3 = this.mBuilder;
                if (builder3 != null) {
                    Intrinsics.checkNotNull(builder3);
                    if (builder3.getMMessageMaxLine$lib_dialog_release() > 0) {
                        TextView textView9 = this.mMessage;
                        if (textView9 != null) {
                            Builder builder4 = this.mBuilder;
                            Intrinsics.checkNotNull(builder4);
                            textView9.setMaxLines(builder4.getMMessageMaxLine$lib_dialog_release());
                        }
                    }
                }
                TextView textView10 = this.mMessage;
                if (textView10 != null) {
                    textView10.setMaxLines(8);
                }
            }
            TextView textView11 = this.mMessage;
            if (textView11 != null) {
                textView11.setLinkTextColor(AppCompatResources.getColorStateList(this, R.color.obfuscated_res_0x7f0607b5));
            }
            TextView textView12 = this.mMessage;
            if (textView12 != null) {
                textView12.setHighlightColor(0);
            }
            CustomLinkMovementMethod customLinkMovementMethod = new CustomLinkMovementMethod();
            customLinkMovementMethod.setLinkMovementListener(new CustomLinkMovementMethod.OnLinkMovementListener(this) { // from class: com.baidu.android.ext.widget.dialog.BdDialog$setMessage$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdDialog this$0;

                @Override // com.baidu.searchbox.ui.CustomLinkMovementMethod.OnLinkMovementListener
                public void onLinkTouch(TextView widget, MotionEvent event) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, widget, event) == null) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        Intrinsics.checkNotNullParameter(event, "event");
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.ui.CustomLinkMovementMethod.OnLinkMovementListener
                public void onNoLinkTouch(TextView widget, MotionEvent event) {
                    TextView textView13;
                    TextView textView14;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, widget, event) == null) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        Intrinsics.checkNotNullParameter(event, "event");
                        if (event.getAction() == 0) {
                            textView14 = this.this$0.mMessage;
                            if (textView14 != null) {
                                textView14.setLinkTextColor(this.this$0.getResources().getColor(R.color.obfuscated_res_0x7f06000a));
                                return;
                            }
                            return;
                        }
                        textView13 = this.this$0.mMessage;
                        if (textView13 != null) {
                            textView13.setLinkTextColor(AppCompatResources.getColorStateList(this.this$0, R.color.obfuscated_res_0x7f0607b5));
                        }
                    }
                }
            });
            TextView textView13 = this.mMessage;
            if (textView13 != null) {
                textView13.setMovementMethod(customLinkMovementMethod);
            }
            LinearLayout linearLayout4 = this.mMessageContent;
            if (linearLayout4 != null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    i = 0;
                }
                linearLayout4.setVisibility(i);
            }
        }
    }

    public final void setView(View view2) {
        FrameLayout frameLayout;
        Drawable drawable;
        RelativeLayout relativeLayout;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, view2) == null) && (frameLayout = this.mDialogContent) != null) {
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            if (view2 != null) {
                LinearLayout linearLayout = this.mMessageContent;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                FrameLayout frameLayout2 = this.mDialogContent;
                if (frameLayout2 != null) {
                    frameLayout2.addView(view2);
                }
                ArrayList<BottomItem> arrayList = this.mBtnItemList;
                ViewGroup.LayoutParams layoutParams2 = null;
                if (arrayList != null && arrayList.size() > 0) {
                    FrameLayout frameLayout3 = this.mBtnContainer;
                    if (frameLayout3 != null) {
                        layoutParams = frameLayout3.getLayoutParams();
                    } else {
                        layoutParams = null;
                    }
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        FrameLayout frameLayout4 = this.mBtnContainer;
                        if (frameLayout4 != null) {
                            layoutParams2 = frameLayout4.getLayoutParams();
                        }
                        if (layoutParams2 != null) {
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                            layoutParams3.addRule(3, R.id.obfuscated_res_0x7f0908ae);
                            FrameLayout frameLayout5 = this.mBtnContainer;
                            if (frameLayout5 != null) {
                                frameLayout5.setLayoutParams(layoutParams3);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        }
                    }
                    float dimension = getResources().getDimension(R.dimen.obfuscated_res_0x7f0701ac);
                    RoundAngleFrameLayout roundAngleFrameLayout = this.mDialogCustomPanel;
                    if (roundAngleFrameLayout != null) {
                        roundAngleFrameLayout.setTopRadius(dimension);
                        return;
                    }
                    return;
                }
                Builder builder = this.mBuilder;
                if (builder != null) {
                    if (builder != null) {
                        drawable = builder.getMDialogBackGroundDrawable$lib_dialog_release();
                    } else {
                        drawable = null;
                    }
                    if (drawable == null && (relativeLayout = this.mDialogLayout) != null) {
                        relativeLayout.setBackground(null);
                    }
                }
            }
        }
    }

    public final void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            applyImmersion();
            Resources resources = getResources();
            int color = resources.getColor(R.color.obfuscated_res_0x7f06036a);
            int color2 = resources.getColor(R.color.obfuscated_res_0x7f06036b);
            RelativeLayout relativeLayout = this.mDialogLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f08022d, null));
            }
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setTextColor(color);
            }
            TextView textView2 = this.mMessage;
            if (textView2 != null) {
                textView2.setTextColor(color2);
            }
            BdBaseImageView bdBaseImageView = this.mRightClose;
            if (bdBaseImageView != null) {
                bdBaseImageView.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f08023f, null));
            }
            BdBaseImageView bdBaseImageView2 = this.mBottomClose;
            if (bdBaseImageView2 != null) {
                bdBaseImageView2.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f08022e, null));
            }
            View view2 = this.mDivider;
            if (view2 != null) {
                view2.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06036f));
            }
        }
    }
}
