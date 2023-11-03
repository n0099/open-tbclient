package com.baidu.android.ext.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.CustomLinkMovementMethod;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.tieba.R;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0011\b\u0017\u0018\u0000 q2\u00020\u0001:\u0006nopqrsB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0014\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020706H\u0002J(\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006H\u0002J\u0018\u0010=\u001a\u00020>2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010@H\u0002J\u0010\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020\u0006H\u0002J(\u0010C\u001a\u00020-2\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006H\u0002J\n\u0010D\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0006J\b\u0010G\u001a\u00020>H\u0004J\b\u0010H\u001a\u00020>H\u0004J\b\u0010I\u001a\u00020\tH\u0002J\b\u0010J\u001a\u00020>H\u0016J\u0012\u0010K\u001a\u00020>2\b\u0010L\u001a\u0004\u0018\u00010MH\u0014J\b\u0010N\u001a\u00020>H\u0016J\u0010\u0010O\u001a\u00020>2\u0006\u0010P\u001a\u00020\tH\u0016J\u0018\u0010Q\u001a\u00020>2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010@H\u0002J\u0015\u0010R\u001a\u00020>2\u0006\u0010S\u001a\u00020\u0018H\u0010¢\u0006\u0002\bTJ\u001c\u0010U\u001a\u00020>2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010YH\u0004J\u0010\u0010Z\u001a\u00020>2\u0006\u0010[\u001a\u00020\tH\u0016J\u0017\u0010\\\u001a\u00020>2\b\u0010]\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010^J\u0012\u0010_\u001a\u00020>2\b\u0010`\u001a\u0004\u0018\u00010YH\u0004J?\u0010a\u001a\u00020>2\b\u0010b\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010\t2\b\u0010F\u001a\u0004\u0018\u00010\u00062\b\u0010e\u001a\u0004\u0018\u00010\t2\b\u0010f\u001a\u0004\u0018\u00010\u0006H\u0004¢\u0006\u0002\u0010gJ\u0012\u0010h\u001a\u00020>2\b\u0010i\u001a\u0004\u0018\u000107H\u0004J\u0012\u0010j\u001a\u00020>2\b\u0010k\u001a\u0004\u0018\u00010&H\u0004J\b\u0010l\u001a\u00020>H\u0004J\b\u0010m\u001a\u00020>H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006t"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "cancelable", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "mBottomClose", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "mBreakPoint", "mBtnContainer", "Landroid/widget/FrameLayout;", "mBtnHeight", "mBtnItemList", "Ljava/util/ArrayList;", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$ButtonItem;", "Lkotlin/collections/ArrayList;", "mBuilder", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$Builder;", "mDialogContent", "mDialogCustomPanel", "Lcom/baidu/android/ext/widget/dialog/RoundAngleFrameLayout;", "mDialogInterface", "Landroid/content/DialogInterface;", "mDialogInternalClose", "mDialogLayout", "Landroid/widget/RelativeLayout;", "getMDialogLayout", "()Landroid/widget/RelativeLayout;", "setMDialogLayout", "(Landroid/widget/RelativeLayout;)V", "mDivider", "Landroid/view/View;", "mIcon", "Landroid/widget/ImageView;", "mImmersionEnabled", "mMessage", "Landroid/widget/TextView;", "mMessageContent", "Landroid/widget/LinearLayout;", "mRightClose", "mTitle", "mTitlePanel", "getMTitlePanel", "()Landroid/widget/LinearLayout;", "setMTitlePanel", "(Landroid/widget/LinearLayout;)V", "checkDialogInVisible", "Lkotlin/Pair;", "", "createButton", "item", "parent", "index", "btnsSize", "createButtonItem", "", "data", "", "createDivider", "orientation", "createStressButton", "getBuilder", "getCompatibleColor", "textColor", "initResources", "initViews", "isCustomViewNoButton", "onAttachedToWindow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "setBottomCloseVisible", MapBundleKey.MapObjKey.OBJ_SL_VISI, "setBtnItemList", "setBuilder", "builder", "setBuilder$lib_dialog_release", "setCloseIconPosition", "closeIconPosition", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$CancelXPosition;", "closeDrawable", "Landroid/graphics/drawable/Drawable;", "setEnableImmersion", "enable", "setHideBotton", "hideBtns", "(Ljava/lang/Boolean;)V", "setIcon", "icon", "setMessage", "message", "", "messageTextBlod", "isMessageTitle", "messageTextGravity", "(Ljava/lang/CharSequence;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "setTitle", "title", "setView", "view", "setupViews", "show", "Builder", "ButtonItem", "CancelXPosition", "Companion", "OnItemClickListener", "ViewHelper", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class BdAlertDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECK_VISIBLE_DECORWH_VALUE = 1;
    public static final float CHECK_VISIBLE_DIALOG_ALPHA = 0.1f;
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
    public static final String RESEARCH_UBC_EXT_KEY = "buginfo";
    public static final String RESEARCH_UBC_FROM = "research";
    public static final String RESEARCH_UBC_ID = "4136";
    public static final String TAG = "BdDialog";
    public static final int THREE_BUTTON_SIZE = 2;
    public static final int TWO_BUTTON_SIZE = 2;
    public static final int TYPE_CANCEL_EVENT = -100;
    public static final String UBC_TYPE_DECOR_WH = "2";
    public static final String UBC_TYPE_DIALOG_NOT_SHOWN = "4";
    public static final String UBC_TYPE_DIALOG_NULL = "3";
    public static final String UBC_TYPE_DIALOG_RECT_INVISIBLE = "6";
    public static final String UBC_TYPE_DIALOG_TRANSPARENT = "5";
    public static final String UBC_TYPE_UNKNOWN = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public BdBaseImageView mBottomClose;
    public final int mBreakPoint;
    public FrameLayout mBtnContainer;
    public int mBtnHeight;
    public ArrayList<ButtonItem> mBtnItemList;
    public Builder mBuilder;
    public FrameLayout mDialogContent;
    public RoundAngleFrameLayout mDialogCustomPanel;
    public DialogInterface mDialogInterface;
    public boolean mDialogInternalClose;
    public RelativeLayout mDialogLayout;
    public View mDivider;
    public ImageView mIcon;
    public boolean mImmersionEnabled;
    public TextView mMessage;
    public LinearLayout mMessageContent;
    public BdBaseImageView mRightClose;
    public TextView mTitle;
    public LinearLayout mTitlePanel;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1642119970, "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$WhenMappings;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1642119970, "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$WhenMappings;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1859448945, "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1859448945, "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0007\u0010\u0083\u0001\u001a\u000209J\u0012\u0010\u0084\u0001\u001a\u00020\u00002\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010@J\u0012\u0010\u0086\u0001\u001a\u00020\u00002\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010GJ\u001d\u0010\u0086\u0001\u001a\u00020\u00002\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010G2\t\u0010\u0088\u0001\u001a\u0004\u0018\u000100J\u0019\u0010\u0089\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0003\u0010\u008a\u0001J\u000f\u0010\u008b\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u000f\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0006J\u0011\u0010\u008d\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J+\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008f\u0001\u001a\u00020T2\u0007\u0010\u0090\u0001\u001a\u00020T2\u0007\u0010\u0091\u0001\u001a\u00020T2\u0007\u0010\u0092\u0001\u001a\u00020TJ\u0012\u0010\u0093\u0001\u001a\u00020\u00002\t\u0010\u0094\u0001\u001a\u0004\u0018\u000100J\u0017\u0010\u0095\u0001\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\u0006¢\u0006\u0003\u0010\u008a\u0001J\u0012\u0010\u0096\u0001\u001a\u00020\u00002\t\u0010\u0097\u0001\u001a\u0004\u0018\u000100J\u0010\u0010\u0096\u0001\u001a\u00020\u00002\u0007\u0010\u0098\u0001\u001a\u00020TJ\u0012\u0010\u0099\u0001\u001a\u00020\u00002\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010]J\u0010\u0010\u0099\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020TJ\u0012\u0010\u0099\u0001\u001a\u00020\u00002\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010'J\u0018\u0010\u009c\u0001\u001a\u00020\u00002\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0003\u0010\u008a\u0001J\u0018\u0010\u009e\u0001\u001a\u00020\u00002\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010T¢\u0006\u0003\u0010 \u0001J\u0010\u0010¡\u0001\u001a\u00020\u00002\u0007\u0010¢\u0001\u001a\u00020TJ\u0010\u0010£\u0001\u001a\u00020\u00002\u0007\u0010¤\u0001\u001a\u00020TJ\u0017\u0010¥\u0001\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u0006¢\u0006\u0003\u0010\u008a\u0001J\u0011\u0010¦\u0001\u001a\u00020\u00002\b\u0010§\u0001\u001a\u00030¨\u0001J\u0012\u0010©\u0001\u001a\u00020\u00002\t\u0010ª\u0001\u001a\u0004\u0018\u00010oJ\u0012\u0010«\u0001\u001a\u00020\u00002\t\u0010ª\u0001\u001a\u0004\u0018\u00010!J\u0010\u0010¬\u0001\u001a\u00020\u00002\u0007\u0010\u00ad\u0001\u001a\u00020TJ\u0012\u0010¬\u0001\u001a\u00020\u00002\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010'J\u0010\u0010®\u0001\u001a\u00020\u00002\u0007\u0010¯\u0001\u001a\u00020TJ\u0012\u0010°\u0001\u001a\u00020\u00002\t\u0010±\u0001\u001a\u0004\u0018\u00010\u0015J6\u0010°\u0001\u001a\u00020\u00002\t\u0010±\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010²\u0001\u001a\u00020T2\u0007\u0010³\u0001\u001a\u00020T2\u0007\u0010´\u0001\u001a\u00020T2\u0007\u0010µ\u0001\u001a\u00020TJ\u0012\u0010¶\u0001\u001a\u00020\u00002\t\u0010ª\u0001\u001a\u0004\u0018\u00010uJ\u0012\u0010·\u0001\u001a\u00020\u00002\t\u0010ª\u0001\u001a\u0004\u0018\u00010{R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\nR\u001c\u0010/\u001a\u0004\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010\u0010R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00102\"\u0004\bE\u00104R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010\u0004R\u001c\u0010P\u001a\u0004\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00102\"\u0004\bR\u00104R\u001a\u0010S\u001a\u00020TX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020TX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u000e\"\u0004\bd\u0010\u0010R\u001e\u0010e\u001a\u0004\u0018\u00010TX\u0080\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001e\u0010k\u001a\u0004\u0018\u00010TX\u0080\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bl\u0010g\"\u0004\bm\u0010iR\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001c\u0010z\u001a\u0004\u0018\u00010{X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010)\"\u0005\b\u0082\u0001\u0010+¨\u0006¸\u0001"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancelOutside", "", "getCancelOutside$lib_dialog_release", "()Ljava/lang/Boolean;", "setCancelOutside$lib_dialog_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "clickDismiss", "getClickDismiss$lib_dialog_release", "()Z", "setClickDismiss$lib_dialog_release", "(Z)V", "closeDismiss", "getCloseDismiss$lib_dialog_release", "setCloseDismiss$lib_dialog_release", "contentView", "Landroid/view/View;", "getContentView$lib_dialog_release", "()Landroid/view/View;", "setContentView$lib_dialog_release", "(Landroid/view/View;)V", "customPanelMarginLayoutParams", "", "getCustomPanelMarginLayoutParams$lib_dialog_release", "()[I", "setCustomPanelMarginLayoutParams$lib_dialog_release", "([I)V", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener$lib_dialog_release", "()Landroid/content/DialogInterface$OnDismissListener;", "setDismissListener$lib_dialog_release", "(Landroid/content/DialogInterface$OnDismissListener;)V", "from", "", "getFrom$lib_dialog_release", "()Ljava/lang/String;", "setFrom$lib_dialog_release", "(Ljava/lang/String;)V", "hideBtns", "getHideBtns$lib_dialog_release", "setHideBtns$lib_dialog_release", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon$lib_dialog_release", "()Landroid/graphics/drawable/Drawable;", "setIcon$lib_dialog_release", "(Landroid/graphics/drawable/Drawable;)V", "isMessageTitle", "isMessageTitle$lib_dialog_release", "setMessageTitle$lib_dialog_release", "mBdAlertDialog", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;", "getMBdAlertDialog", "()Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;", "setMBdAlertDialog", "(Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;)V", "mBtnList", "", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$ButtonItem;", "getMBtnList$lib_dialog_release", "()Ljava/util/List;", "mCancelXDrawable", "getMCancelXDrawable$lib_dialog_release", "setMCancelXDrawable$lib_dialog_release", "mCancelXPosition", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$CancelXPosition;", "getMCancelXPosition$lib_dialog_release", "()Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$CancelXPosition;", "setMCancelXPosition$lib_dialog_release", "(Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$CancelXPosition;)V", "mContext", "getMContext$lib_dialog_release", "()Landroid/content/Context;", "setMContext$lib_dialog_release", "mDialogBackGroundDrawable", "getMDialogBackGroundDrawable$lib_dialog_release", "setMDialogBackGroundDrawable$lib_dialog_release", "mMessageMaxLine", "", "getMMessageMaxLine$lib_dialog_release", "()I", "setMMessageMaxLine$lib_dialog_release", "(I)V", "mTopRightCancelXMarginRight", "getMTopRightCancelXMarginRight$lib_dialog_release", "setMTopRightCancelXMarginRight$lib_dialog_release", "message", "", "getMessage$lib_dialog_release", "()Ljava/lang/CharSequence;", "setMessage$lib_dialog_release", "(Ljava/lang/CharSequence;)V", "messageTextBlod", "getMessageTextBlod$lib_dialog_release", "setMessageTextBlod$lib_dialog_release", "messageTextColor", "getMessageTextColor$lib_dialog_release", "()Ljava/lang/Integer;", "setMessageTextColor$lib_dialog_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "messageTextGravity", "getMessageTextGravity$lib_dialog_release", "setMessageTextGravity$lib_dialog_release", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener$lib_dialog_release", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener$lib_dialog_release", "(Landroid/content/DialogInterface$OnCancelListener;)V", "onKeyListener", "Landroid/content/DialogInterface$OnKeyListener;", "getOnKeyListener$lib_dialog_release", "()Landroid/content/DialogInterface$OnKeyListener;", "setOnKeyListener$lib_dialog_release", "(Landroid/content/DialogInterface$OnKeyListener;)V", "onShowListener", "Landroid/content/DialogInterface$OnShowListener;", "getOnShowListener$lib_dialog_release", "()Landroid/content/DialogInterface$OnShowListener;", "setOnShowListener$lib_dialog_release", "(Landroid/content/DialogInterface$OnShowListener;)V", "title", "getTitle$lib_dialog_release", "setTitle$lib_dialog_release", "create", "setButton", "item", "setCancelXPosition", "cancelXPosition", "cancelXDrawable", "setCancelableOutside", "(Ljava/lang/Boolean;)Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$Builder;", "setClickDismiss", "setCloseDismiss", "setContext", "setCustomPanelMargin", "left", "top", "right", "bottom", "setDialogBackGroundDrawable", "dialogBackGroundDrawable", "setHideBtns", "setIcon", ResourceManager.DRAWABLE, "iconId", "setMessage", "text", MiPushMessage.KEY_MESSAGE_ID, "setMessageBlod", "isBlod", "setMessageGravity", NotificationCompat.WearableExtender.KEY_GRAVITY, "(Ljava/lang/Integer;)Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$Builder;", "setMessageMaxLine", "maxLine", "setMessageTextColor", "textColor", "setMessageTitle", "setMsgClickSpan", "clickInfo", "Lcom/baidu/android/ext/widget/dialog/ClickSpanInfo;", "setOnCancelListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnDismissListener", "setTitle", "titleId", "setTopRightCancelXMarginRight", "topRightCancelXMarginRight", "setView", "view", "viewSpacingLeft", "viewSpacingTop", "viewSpacingRight", "viewSpacingBottom", "setonKeyListener", "setonShowListener", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean cancelOutside;
        public boolean clickDismiss;
        public boolean closeDismiss;
        public View contentView;
        public int[] customPanelMarginLayoutParams;
        public DialogInterface.OnDismissListener dismissListener;
        public String from;
        public Boolean hideBtns;
        public Drawable icon;
        public boolean isMessageTitle;
        public BdAlertDialog mBdAlertDialog;
        public final List<ButtonItem> mBtnList;
        public Drawable mCancelXDrawable;
        public CancelXPosition mCancelXPosition;
        public Context mContext;
        public Drawable mDialogBackGroundDrawable;
        public int mMessageMaxLine;
        public int mTopRightCancelXMarginRight;
        public CharSequence message;
        public boolean messageTextBlod;
        public Integer messageTextColor;
        public Integer messageTextGravity;
        public DialogInterface.OnCancelListener onCancelListener;
        public DialogInterface.OnKeyListener onKeyListener;
        public DialogInterface.OnShowListener onShowListener;
        public String title;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(context, "context");
            this.mMessageMaxLine = -1;
            Boolean bool = Boolean.FALSE;
            this.hideBtns = bool;
            this.cancelOutside = bool;
            this.mBtnList = new ArrayList();
            this.mTopRightCancelXMarginRight = -1;
            this.clickDismiss = true;
            this.closeDismiss = true;
            this.mContext = context;
        }

        private final Builder setCancelableOutside(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bool)) == null) {
                this.cancelOutside = bool;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setButton(ButtonItem buttonItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, buttonItem)) == null) {
                if (buttonItem != null) {
                    this.mBtnList.add(buttonItem);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setCancelOutside$lib_dialog_release(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, bool) == null) {
                this.cancelOutside = bool;
            }
        }

        public final Builder setCancelXPosition(CancelXPosition cancelXPosition) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, cancelXPosition)) == null) {
                this.mCancelXPosition = cancelXPosition;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setClickDismiss(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
                this.clickDismiss = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final void setClickDismiss$lib_dialog_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
                this.clickDismiss = z;
            }
        }

        public final Builder setCloseDismiss(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
                this.closeDismiss = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public final void setCloseDismiss$lib_dialog_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
                this.closeDismiss = z;
            }
        }

        public final void setContentView$lib_dialog_release(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048611, this, view2) == null) {
                this.contentView = view2;
            }
        }

        public final Builder setContext(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, context)) == null) {
                this.mContext = context;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setCustomPanelMarginLayoutParams$lib_dialog_release(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048614, this, iArr) == null) {
                this.customPanelMarginLayoutParams = iArr;
            }
        }

        public final Builder setDialogBackGroundDrawable(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, drawable)) == null) {
                this.mDialogBackGroundDrawable = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setDismissListener$lib_dialog_release(DialogInterface.OnDismissListener onDismissListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048616, this, onDismissListener) == null) {
                this.dismissListener = onDismissListener;
            }
        }

        public final void setFrom$lib_dialog_release(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
                this.from = str;
            }
        }

        public final Builder setHideBtns(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, bool)) == null) {
                if (bool != null) {
                    this.hideBtns = bool;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setHideBtns$lib_dialog_release(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048619, this, bool) == null) {
                this.hideBtns = bool;
            }
        }

        public final Builder setIcon(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                return setIcon(ResourcesCompat.getDrawable(context.getResources(), i, null));
            }
            return (Builder) invokeI.objValue;
        }

        public final void setIcon$lib_dialog_release(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048622, this, drawable) == null) {
                this.icon = drawable;
            }
        }

        public final void setMBdAlertDialog(BdAlertDialog bdAlertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048623, this, bdAlertDialog) == null) {
                this.mBdAlertDialog = bdAlertDialog;
            }
        }

        public final void setMCancelXDrawable$lib_dialog_release(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048624, this, drawable) == null) {
                this.mCancelXDrawable = drawable;
            }
        }

        public final void setMCancelXPosition$lib_dialog_release(CancelXPosition cancelXPosition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048625, this, cancelXPosition) == null) {
                this.mCancelXPosition = cancelXPosition;
            }
        }

        public final void setMContext$lib_dialog_release(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048626, this, context) == null) {
                this.mContext = context;
            }
        }

        public final void setMDialogBackGroundDrawable$lib_dialog_release(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048627, this, drawable) == null) {
                this.mDialogBackGroundDrawable = drawable;
            }
        }

        public final void setMMessageMaxLine$lib_dialog_release(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
                this.mMessageMaxLine = i;
            }
        }

        public final void setMTopRightCancelXMarginRight$lib_dialog_release(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
                this.mTopRightCancelXMarginRight = i;
            }
        }

        public final Builder setMessage(int i) {
            InterceptResult invokeI;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i)) == null) {
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
            if (interceptable == null || interceptable.invokeL(1048633, this, charSequence) == null) {
                this.message = charSequence;
            }
        }

        public final Builder setMessageBlod(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, bool)) == null) {
                if (bool != null) {
                    this.messageTextBlod = bool.booleanValue();
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setMessageGravity(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, num)) == null) {
                this.messageTextGravity = num;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setMessageMaxLine(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i)) == null) {
                this.mMessageMaxLine = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final void setMessageTextBlod$lib_dialog_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
                this.messageTextBlod = z;
            }
        }

        public final Builder setMessageTextColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i)) == null) {
                this.messageTextColor = Integer.valueOf(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final void setMessageTextColor$lib_dialog_release(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048639, this, num) == null) {
                this.messageTextColor = num;
            }
        }

        public final void setMessageTextGravity$lib_dialog_release(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048640, this, num) == null) {
                this.messageTextGravity = num;
            }
        }

        public final Builder setMessageTitle(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, bool)) == null) {
                if (bool != null) {
                    this.isMessageTitle = bool.booleanValue();
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setMessageTitle$lib_dialog_release(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
                this.isMessageTitle = z;
            }
        }

        public final Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, onCancelListener)) == null) {
                this.onCancelListener = onCancelListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setOnCancelListener$lib_dialog_release(DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048645, this, onCancelListener) == null) {
                this.onCancelListener = onCancelListener;
            }
        }

        public final Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, onDismissListener)) == null) {
                this.dismissListener = onDismissListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final void setOnKeyListener$lib_dialog_release(DialogInterface.OnKeyListener onKeyListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048647, this, onKeyListener) == null) {
                this.onKeyListener = onKeyListener;
            }
        }

        public final void setOnShowListener$lib_dialog_release(DialogInterface.OnShowListener onShowListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048648, this, onShowListener) == null) {
                this.onShowListener = onShowListener;
            }
        }

        public final Builder setTitle(int i) {
            InterceptResult invokeI;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048649, this, i)) == null) {
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
            if (interceptable == null || interceptable.invokeL(1048651, this, str) == null) {
                this.title = str;
            }
        }

        public final Builder setTopRightCancelXMarginRight(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i)) == null) {
                this.mTopRightCancelXMarginRight = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public final Builder setView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, view2)) == null) {
                this.contentView = view2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setonKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, onKeyListener)) == null) {
                this.onKeyListener = onKeyListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setonShowListener(DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, onShowListener)) == null) {
                this.onShowListener = onShowListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final BdAlertDialog create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                BdAlertDialog bdAlertDialog = new BdAlertDialog(context, R.style.obfuscated_res_0x7f10014f);
                this.mBdAlertDialog = bdAlertDialog;
                if (bdAlertDialog != null) {
                    bdAlertDialog.setBuilder$lib_dialog_release(this);
                }
                BdAlertDialog bdAlertDialog2 = this.mBdAlertDialog;
                if (bdAlertDialog2 != null) {
                    return bdAlertDialog2;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.ext.widget.dialog.BdAlertDialog");
            }
            return (BdAlertDialog) invokeV.objValue;
        }

        public final Boolean getCancelOutside$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.cancelOutside;
            }
            return (Boolean) invokeV.objValue;
        }

        public final boolean getClickDismiss$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.clickDismiss;
            }
            return invokeV.booleanValue;
        }

        public final boolean getCloseDismiss$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.closeDismiss;
            }
            return invokeV.booleanValue;
        }

        public final View getContentView$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.contentView;
            }
            return (View) invokeV.objValue;
        }

        public final int[] getCustomPanelMarginLayoutParams$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.customPanelMarginLayoutParams;
            }
            return (int[]) invokeV.objValue;
        }

        public final DialogInterface.OnDismissListener getDismissListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.dismissListener;
            }
            return (DialogInterface.OnDismissListener) invokeV.objValue;
        }

        public final String getFrom$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.from;
            }
            return (String) invokeV.objValue;
        }

        public final Boolean getHideBtns$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.hideBtns;
            }
            return (Boolean) invokeV.objValue;
        }

        public final Drawable getIcon$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.icon;
            }
            return (Drawable) invokeV.objValue;
        }

        public final BdAlertDialog getMBdAlertDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.mBdAlertDialog;
            }
            return (BdAlertDialog) invokeV.objValue;
        }

        public final List<ButtonItem> getMBtnList$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.mBtnList;
            }
            return (List) invokeV.objValue;
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

        public final int getMTopRightCancelXMarginRight$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.mTopRightCancelXMarginRight;
            }
            return invokeV.intValue;
        }

        public final CharSequence getMessage$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.message;
            }
            return (CharSequence) invokeV.objValue;
        }

        public final boolean getMessageTextBlod$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.messageTextBlod;
            }
            return invokeV.booleanValue;
        }

        public final Integer getMessageTextColor$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.messageTextColor;
            }
            return (Integer) invokeV.objValue;
        }

        public final Integer getMessageTextGravity$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.messageTextGravity;
            }
            return (Integer) invokeV.objValue;
        }

        public final DialogInterface.OnCancelListener getOnCancelListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.onCancelListener;
            }
            return (DialogInterface.OnCancelListener) invokeV.objValue;
        }

        public final DialogInterface.OnKeyListener getOnKeyListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.onKeyListener;
            }
            return (DialogInterface.OnKeyListener) invokeV.objValue;
        }

        public final DialogInterface.OnShowListener getOnShowListener$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.onShowListener;
            }
            return (DialogInterface.OnShowListener) invokeV.objValue;
        }

        public final String getTitle$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public final boolean isMessageTitle$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.isMessageTitle;
            }
            return invokeV.booleanValue;
        }

        public final Builder setCancelXPosition(CancelXPosition cancelXPosition, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, cancelXPosition, drawable)) == null) {
                this.mCancelXPosition = cancelXPosition;
                this.mCancelXDrawable = drawable;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public final Builder setCustomPanelMargin(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048613, this, i, i2, i3, i4)) == null) {
                this.customPanelMarginLayoutParams = new int[]{i, i2, i3, i4};
                return this;
            }
            return (Builder) invokeIIII.objValue;
        }

        public final Builder setIcon(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, drawable)) == null) {
                this.icon = drawable;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setMessage(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, charSequence)) == null) {
                this.message = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setTitle(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, str)) == null) {
                this.title = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setMessage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
                this.message = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public final Builder setMsgClickSpan(ClickSpanInfo clickInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, clickInfo)) == null) {
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
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048654, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                this.contentView = view2;
                this.customPanelMarginLayoutParams = new int[]{i, i2, i3, i4};
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fBC\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eBK\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0012B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0013B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0014B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0015B9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0017B!\b\u0016\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0018B)\b\u0016\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0019B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001aB)\b\u0016\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001bB1\b\u0016\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001cJ\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CR\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010:\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00101\"\u0004\b<\u00103R\u001e\u0010=\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b>\u00106\"\u0004\b?\u00108¨\u0006D"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$ButtonItem;", "", "text", "", "subText", "textColor", "", "subTextColor", "blodTextStyle", "", "onItemClickListener", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZLcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "isStressButtonStyle", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZLcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "stressBgId", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZILcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;ILcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;ZILcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;IZILcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;IZLcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;IZZLcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;IZIZLcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(ZLjava/lang/CharSequence;Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(ZILjava/lang/CharSequence;Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(Ljava/lang/CharSequence;ZLcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(ZLjava/lang/CharSequence;ZLcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "(ZILjava/lang/CharSequence;ZLcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "mBlodTextStyle", "getMBlodTextStyle", "()Z", "setMBlodTextStyle", "(Z)V", "mIsStressButtonStyle", "getMIsStressButtonStyle", "setMIsStressButtonStyle", "mOnItemClickListener", "getMOnItemClickListener", "()Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;", "setMOnItemClickListener", "(Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$OnItemClickListener;)V", "mStressBgId", "getMStressBgId", "()I", "setMStressBgId", "(I)V", "mSubText", "getMSubText", "()Ljava/lang/CharSequence;", "setMSubText", "(Ljava/lang/CharSequence;)V", "mSubTextColor", "getMSubTextColor", "()Ljava/lang/Integer;", "setMSubTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mText", "getMText", "setMText", "mTextColor", "getMTextColor", "setMTextColor", "onItemClick", "", "view", "Landroid/view/View;", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ButtonItem {
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

        public ButtonItem(CharSequence text, int i, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, int i, boolean z, int i2, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, int i, boolean z, int i2, boolean z2, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, int i, boolean z, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, int i, boolean z, boolean z2, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, CharSequence charSequence, int i, int i2, boolean z, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, CharSequence charSequence, int i, int i2, boolean z, boolean z2, int i3, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, CharSequence charSequence, int i, int i2, boolean z, boolean z2, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, boolean z, int i, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(CharSequence text, boolean z, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(boolean z, int i, CharSequence text, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(boolean z, int i, CharSequence text, boolean z2, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(boolean z, CharSequence text, OnItemClickListener onItemClickListener) {
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

        public ButtonItem(boolean z, CharSequence text, boolean z2, OnItemClickListener onItemClickListener) {
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$CancelXPosition;", "", "(Ljava/lang/String;I)V", "BOTTOM", "TOP_RIGHT", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-235360978, "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$CancelXPosition;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-235360978, "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$CancelXPosition;");
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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$Companion;", "", "()V", "CHECK_VISIBLE_DECORWH_VALUE", "", "CHECK_VISIBLE_DIALOG_ALPHA", "", "DEBUG", "", "DEFAULT_BREAK_POINT", "DIALOG_OUTSIDE_BG_ALPHA", "DIALOG_OUTSIDE_BG_ALPHA_NIGHT", "DIALOG_WITH_SCALE", "KEY_FOR_BUILDER", "", "KEY_FROM", "MESSAGE_TEXT_MAX_LINE", "MESSAGE_TITLE_TEXT_MAX_LINE", "ONE_BUTTON_SIZE", "RESEARCH_UBC_EXT_KEY", "RESEARCH_UBC_FROM", "RESEARCH_UBC_ID", "TAG", "THREE_BUTTON_SIZE", "TWO_BUTTON_SIZE", "TYPE_CANCEL_EVENT", "UBC_TYPE_DECOR_WH", "UBC_TYPE_DIALOG_NOT_SHOWN", "UBC_TYPE_DIALOG_NULL", "UBC_TYPE_DIALOG_RECT_INVISIBLE", "UBC_TYPE_DIALOG_TRANSPARENT", "UBC_TYPE_UNKNOWN", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006!"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$ViewHelper;", "", "view", "Landroid/view/View;", "dialog", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;", "(Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;Landroid/view/View;Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;)V", NativeConstants.ID_BUTTON, "Landroid/widget/LinearLayout;", "getButton$lib_dialog_release", "()Landroid/widget/LinearLayout;", "setButton$lib_dialog_release", "(Landroid/widget/LinearLayout;)V", "mDialog", "getMDialog$lib_dialog_release", "()Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;", "setMDialog$lib_dialog_release", "(Lcom/baidu/android/ext/widget/dialog/BdAlertDialog;)V", "subText", "Landroid/widget/TextView;", "getSubText$lib_dialog_release", "()Landroid/widget/TextView;", "setSubText$lib_dialog_release", "(Landroid/widget/TextView;)V", "text", "getText$lib_dialog_release", "setText$lib_dialog_release", "onBindView", "", "item", "Lcom/baidu/android/ext/widget/dialog/BdAlertDialog$ButtonItem;", "index", "", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class ViewHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout button;
        public BdAlertDialog mDialog;
        public TextView subText;
        public TextView text;
        public final /* synthetic */ BdAlertDialog this$0;

        public ViewHelper(BdAlertDialog bdAlertDialog, View view2, BdAlertDialog bdAlertDialog2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdAlertDialog, view2, bdAlertDialog2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdAlertDialog;
            if (view2 != null) {
                this.text = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090394);
                this.subText = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090393);
                this.button = (LinearLayout) view2;
                this.mDialog = bdAlertDialog2;
            }
        }

        /* renamed from: onBindView$lambda-0  reason: not valid java name */
        public static final void m33onBindView$lambda0(ButtonItem buttonItem, ViewHelper this$0, BdAlertDialog this$1, View view2) {
            Builder builder;
            OnItemClickListener mOnItemClickListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65537, null, buttonItem, this$0, this$1, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                if (buttonItem.getMOnItemClickListener() != null && (mOnItemClickListener = buttonItem.getMOnItemClickListener()) != null) {
                    Intrinsics.checkNotNullExpressionValue(view2, "view");
                    mOnItemClickListener.onItemClick(view2);
                }
                BdAlertDialog bdAlertDialog = this$0.mDialog;
                boolean z = true;
                if ((bdAlertDialog == null || (builder = bdAlertDialog.getBuilder()) == null || !builder.getClickDismiss$lib_dialog_release()) ? false : false) {
                    this$1.dismiss();
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

        public final BdAlertDialog getMDialog$lib_dialog_release() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mDialog;
            }
            return (BdAlertDialog) invokeV.objValue;
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

        public final void onBindView(final ButtonItem buttonItem, int i) {
            TextView textView;
            TextView textView2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048580, this, buttonItem, i) != null) || buttonItem == null) {
                return;
            }
            TextView textView3 = this.text;
            if (textView3 != null) {
                textView3.setText(buttonItem.getMText());
            }
            TextView textView4 = this.text;
            if (textView4 != null) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView4, 0, R.dimen.bd_dialog_bd_button_size, 0, 4, null);
            }
            TextView textView5 = this.subText;
            if (textView5 != null) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView5, 0, R.dimen.bd_dialog_bd_sub_button_size, 0, 4, null);
            }
            Integer mTextColor = buttonItem.getMTextColor();
            if (mTextColor != null) {
                TextView textView6 = this.text;
                if (textView6 != null) {
                    textView6.setTextColor(this.this$0.getCompatibleColor(mTextColor.intValue()));
                }
            } else {
                TextView textView7 = this.text;
                if (textView7 != null) {
                    textView7.setTextColor(this.this$0.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060375));
                }
            }
            if (buttonItem.getMBlodTextStyle() && (textView2 = this.text) != null) {
                textView2.setTypeface(Typeface.defaultFromStyle(1));
            }
            if (!TextUtils.isEmpty(buttonItem.getMSubText())) {
                TextView textView8 = this.subText;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
                TextView textView9 = this.subText;
                if (textView9 != null) {
                    textView9.setText(buttonItem.getMSubText());
                }
            } else {
                TextView textView10 = this.subText;
                if (textView10 != null) {
                    textView10.setVisibility(8);
                }
            }
            Integer mSubTextColor = buttonItem.getMSubTextColor();
            if (mSubTextColor != null && (textView = this.subText) != null) {
                textView.setTextColor(this.this$0.getCompatibleColor(mSubTextColor.intValue()));
            }
            LinearLayout linearLayout = this.button;
            if (linearLayout != null) {
                final BdAlertDialog bdAlertDialog = this.this$0;
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.oj
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            BdAlertDialog.ViewHelper.m33onBindView$lambda0(BdAlertDialog.ButtonItem.this, this, bdAlertDialog, view2);
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

        public final void setMDialog$lib_dialog_release(BdAlertDialog bdAlertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bdAlertDialog) == null) {
                this.mDialog = bdAlertDialog;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdAlertDialog(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBreakPoint = 2;
        this.mBtnItemList = new ArrayList<>();
        this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Boolean cancelOutside$lib_dialog_release;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d015c);
            Builder builder = getBuilder();
            this.mBuilder = builder;
            if (builder == null) {
                dismiss();
                return;
            }
            if (NightModeHelper.getNightModeSwitcherState()) {
                Window window = getWindow();
                if (window != null) {
                    window.setDimAmount(0.65f);
                }
            } else {
                Window window2 = getWindow();
                if (window2 != null) {
                    window2.setDimAmount(0.5f);
                }
            }
            this.mDialogInterface = this;
            Builder builder2 = this.mBuilder;
            if (builder2 != null && (cancelOutside$lib_dialog_release = builder2.getCancelOutside$lib_dialog_release()) != null) {
                setCanceledOnTouchOutside(cancelOutside$lib_dialog_release.booleanValue());
            }
            initViews();
            initResources();
            setupViews();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdAlertDialog(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBreakPoint = 2;
        this.mBtnItemList = new ArrayList<>();
        this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), onCancelListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBreakPoint = 2;
        this.mBtnItemList = new ArrayList<>();
        this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;
    }

    private final void setBtnItemList(List<ButtonItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, list) == null) {
            this.mBtnItemList.clear();
            if (list != null) {
                this.mBtnItemList.addAll(list);
            }
        }
    }

    private final void setHideBotton(Boolean bool) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, this, bool) == null) && this.mBtnContainer != null && bool != null && bool.booleanValue() && (frameLayout = this.mBtnContainer) != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final int getCompatibleColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            try {
                if (TextUtils.equals(getContext().getResources().getResourceTypeName(i), "color")) {
                    return getContext().getResources().getColor(i);
                }
                return i;
            } catch (Resources.NotFoundException unused) {
                return i;
            }
        }
        return invokeI.intValue;
    }

    public void setBottomCloseVisible(boolean z) {
        BdBaseImageView bdBaseImageView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (bdBaseImageView = this.mBottomClose) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            bdBaseImageView.setVisibility(i);
        }
    }

    public void setBuilder$lib_dialog_release(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, builder) == null) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.mBuilder = builder;
        }
    }

    public void setEnableImmersion(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (ImmersionHelper.SUPPORT_IMMERSION && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mImmersionEnabled = z2;
        }
    }

    public final void setIcon(Drawable drawable) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) {
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
            ImageView imageView3 = this.mIcon;
            if (imageView3 != null) {
                FontSizeImageViewExtKt.setScaledImageDrawable$default(imageView3, 0, drawable, 0, 4, null);
            }
        }
    }

    public final void setMDialogLayout(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, relativeLayout) == null) {
            this.mDialogLayout = relativeLayout;
        }
    }

    public final void setMTitlePanel(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, linearLayout) == null) {
            this.mTitlePanel = linearLayout;
        }
    }

    private final Pair<String, String> checkDialogInVisible() {
        InterceptResult invokeV;
        View view2;
        String str;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Window window = getWindow();
            if (window != null) {
                view2 = window.getDecorView();
            } else {
                view2 = null;
            }
            if (view2 != null && view2.getWidth() >= 1 && view2.getHeight() >= 1) {
                RelativeLayout relativeLayout2 = this.mDialogLayout;
                if (relativeLayout2 == null) {
                    return new Pair<>("3", "mDialogLayout == null");
                }
                Intrinsics.checkNotNull(relativeLayout2);
                if (!relativeLayout2.isShown()) {
                    return new Pair<>("4", "mDialogLayout isShown return false");
                }
                RelativeLayout relativeLayout3 = this.mDialogLayout;
                Intrinsics.checkNotNull(relativeLayout3);
                if (relativeLayout3.getAlpha() <= 0.1f) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("mDialogLayout transparent: ");
                    RelativeLayout relativeLayout4 = this.mDialogLayout;
                    Intrinsics.checkNotNull(relativeLayout4);
                    sb.append(relativeLayout4.getAlpha());
                    return new Pair<>("5", sb.toString());
                }
                Rect rect = new Rect();
                Intrinsics.checkNotNull(this.mDialogLayout);
                if (!relativeLayout.getGlobalVisibleRect(rect)) {
                    return new Pair<>("6", "mDialogLayout rect is invisible");
                }
                return new Pair<>("", "");
            }
            if (view2 == null) {
                str = "decorView == null";
            } else {
                str = "width: " + view2.getWidth() + "  height: " + view2.getHeight();
            }
            return new Pair<>("2", str);
        }
        return (Pair) invokeV.objValue;
    }

    public final void setupViews() {
        Builder builder;
        RelativeLayout relativeLayout;
        boolean z;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (builder = this.mBuilder) == null) {
            return;
        }
        if (builder != null) {
            setBtnItemList(builder.getMBtnList$lib_dialog_release());
            setTitle(builder.getTitle$lib_dialog_release());
            setIcon(builder.getIcon$lib_dialog_release());
            setMessage(builder.getMessage$lib_dialog_release(), Boolean.valueOf(builder.getMessageTextBlod$lib_dialog_release()), builder.getMessageTextColor$lib_dialog_release(), Boolean.valueOf(builder.isMessageTitle$lib_dialog_release()), builder.getMessageTextGravity$lib_dialog_release());
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
            }
            if (builder.getOnShowListener$lib_dialog_release() != null) {
                setOnShowListener(builder.getOnShowListener$lib_dialog_release());
            }
            if (builder.getDismissListener$lib_dialog_release() != null) {
                setOnDismissListener(builder.getDismissListener$lib_dialog_release());
            }
            if (builder.getOnCancelListener$lib_dialog_release() != null) {
                setOnCancelListener(builder.getOnCancelListener$lib_dialog_release());
            }
            if (builder.getOnKeyListener$lib_dialog_release() != null) {
                setOnKeyListener(builder.getOnKeyListener$lib_dialog_release());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.android.ext.widget.dialog.BdAlertDialog.Builder");
    }

    private final LinearLayout createButton(ButtonItem buttonItem, LinearLayout linearLayout, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65542, this, buttonItem, linearLayout, i, i2)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0475, (ViewGroup) linearLayout, false);
            if (inflate != null) {
                LinearLayout linearLayout2 = (LinearLayout) inflate;
                Resources resources = getContext().getResources();
                if (i2 == 1) {
                    linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f080238, null), 0, 4, null));
                } else if (i2 == 2) {
                    if (i == 0) {
                        linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f08023b, null), 0, 4, null));
                    }
                    if (i == 1) {
                        linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f08023e, null), 0, 4, null));
                    }
                } else if (i2 >= 2) {
                    if (i == i2 - 1) {
                        linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f080238, null), 0, 4, null));
                    } else {
                        linearLayout2.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f080241, null), 0, 4, null));
                    }
                }
                new ViewHelper(this, linearLayout2, this).onBindView(buttonItem, i);
                return linearLayout2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        return (LinearLayout) invokeLLII.objValue;
    }

    private final void createButtonItem(List<ButtonItem> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, list) == null) && list != null && list.size() > 0) {
            FrameLayout frameLayout = this.mBtnContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            View view2 = this.mDivider;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
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
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060377));
            if (i == 1) {
                view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            } else {
                view2.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public final void setTitle(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
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

    private final LinearLayout createStressButton(final ButtonItem buttonItem, LinearLayout linearLayout, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65545, this, buttonItem, linearLayout, i, i2)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0491, (ViewGroup) linearLayout, false);
            if (inflate != null) {
                LinearLayout linearLayout2 = (LinearLayout) inflate;
                TextView textView = (TextView) linearLayout2.findViewById(R.id.obfuscated_res_0x7f092353);
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView, 0, R.dimen.bd_dialog_stress_button_size, 0, 4, null);
                Resources resources = getContext().getResources();
                if (i2 == 1) {
                    textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f080249, null), 0, 4, null));
                    if (textView != null) {
                        textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060379));
                    }
                } else if (i2 == 2) {
                    if (i == 0) {
                        textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f08024a, null), 0, 4, null));
                        if (textView != null) {
                            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06037b));
                        }
                        if (linearLayout2.getLayoutParams() != null && (linearLayout2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                            ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
                            if (layoutParams != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                                layoutParams2.rightMargin = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b8);
                                linearLayout2.setLayoutParams(layoutParams2);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                            }
                        }
                    }
                    if (i == 1) {
                        textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f080249, null), 0, 4, null));
                        if (textView != null) {
                            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060379));
                        }
                        if (linearLayout2.getLayoutParams() != null && (linearLayout2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                            ViewGroup.LayoutParams layoutParams3 = linearLayout2.getLayoutParams();
                            if (layoutParams3 != null) {
                                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                                layoutParams4.leftMargin = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b8);
                                linearLayout2.setLayoutParams(layoutParams4);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                            }
                        }
                    }
                } else if (i2 >= 2) {
                    if (i == 0) {
                        textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f080249, null), 0, 4, null));
                        if (textView != null) {
                            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060379));
                        }
                    } else {
                        if (textView != null) {
                            textView.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060378));
                        }
                        if (textView != null) {
                            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060375));
                        }
                    }
                    if ((i == 0 || i == 1) && textView.getLayoutParams() != null && (textView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                        ViewGroup.LayoutParams layoutParams5 = textView.getLayoutParams();
                        if (layoutParams5 != null) {
                            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
                            layoutParams6.bottomMargin = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b7);
                            textView.setLayoutParams(layoutParams6);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        }
                    }
                }
                if (buttonItem.getMStressBgId() != -1) {
                    textView.setBackground(FontSizeHelper.getScaledDrawable$default(0, ResourcesCompat.getDrawable(resources, buttonItem.getMStressBgId(), null), 0, 4, null));
                }
                if (textView != null) {
                    textView.setText(buttonItem.getMText());
                }
                Integer mTextColor = buttonItem.getMTextColor();
                if (mTextColor != null && textView != null) {
                    textView.setTextColor(getCompatibleColor(mTextColor.intValue()));
                }
                if (buttonItem.getMBlodTextStyle() && textView != null) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (textView != null) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.qj
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                BdAlertDialog.m29createStressButton$lambda6(BdAlertDialog.ButtonItem.this, this, view2);
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
    public static final void m29createStressButton$lambda6(ButtonItem item, BdAlertDialog this$0, View view2) {
        OnItemClickListener mOnItemClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, item, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (item.getMOnItemClickListener() != null && (mOnItemClickListener = item.getMOnItemClickListener()) != null) {
                Intrinsics.checkNotNullExpressionValue(view2, "view");
                mOnItemClickListener.onItemClick(view2);
            }
            Builder builder = this$0.getBuilder();
            boolean z = true;
            if ((builder == null || !builder.getClickDismiss$lib_dialog_release()) ? false : false) {
                this$0.dismiss();
            }
        }
    }

    private final boolean isCustomViewNoButton() {
        InterceptResult invokeV;
        View view2;
        boolean z;
        List<ButtonItem> mBtnList$lib_dialog_release;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            Builder builder = this.mBuilder;
            if (builder != null) {
                List<ButtonItem> list = null;
                if (builder != null) {
                    view2 = builder.getContentView$lib_dialog_release();
                } else {
                    view2 = null;
                }
                if (view2 != null) {
                    Builder builder2 = this.mBuilder;
                    if (builder2 != null) {
                        list = builder2.getMBtnList$lib_dialog_release();
                    }
                    if (list != null) {
                        Builder builder3 = this.mBuilder;
                        if (builder3 != null && (mBtnList$lib_dialog_release = builder3.getMBtnList$lib_dialog_release()) != null && mBtnList$lib_dialog_release.isEmpty()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            try {
                if (this.mImmersionEnabled) {
                    ImmersionHelper.setDialogImmersion(this);
                }
                super.show();
                if (isCustomViewNoButton()) {
                    Window window = getWindow();
                    if (window != null) {
                        window.setLayout(-1, -1);
                        return;
                    }
                    return;
                }
                float windowWidth = BdDialogKt.getWindowWidth(getWindow()) * 0.8f;
                Window window2 = getWindow();
                if (window2 != null) {
                    window2.setLayout((int) windowWidth, -2);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: onAttachedToWindow$lambda-2  reason: not valid java name */
    public static final void m30onAttachedToWindow$lambda2(BdAlertDialog this$0, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, this$0, z) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.initResources();
            this$0.setupViews();
        }
    }

    /* renamed from: setCloseIconPosition$lambda-4  reason: not valid java name */
    public static final void m32setCloseIconPosition$lambda4(BdAlertDialog this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.cancel();
        }
    }

    /* renamed from: setCloseIconPosition$lambda-3  reason: not valid java name */
    public static final void m31setCloseIconPosition$lambda3(BdAlertDialog this$0, View view2) {
        DialogInterface.OnCancelListener onCancelListener$lib_dialog_release;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Builder builder = this$0.mBuilder;
            boolean z = true;
            if ((builder == null || !builder.getCloseDismiss$lib_dialog_release()) ? false : false) {
                this$0.cancel();
                return;
            }
            Builder builder2 = this$0.mBuilder;
            if (builder2 != null && (onCancelListener$lib_dialog_release = builder2.getOnCancelListener$lib_dialog_release()) != null) {
                onCancelListener$lib_dialog_release.onCancel(this$0);
            }
        }
    }

    public Builder getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBuilder;
        }
        return (Builder) invokeV.objValue;
    }

    public final RelativeLayout getMDialogLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDialogLayout;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final LinearLayout getMTitlePanel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mTitlePanel;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.tieba.mj
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
                public final void onNightModeChanged(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        BdAlertDialog.m30onAttachedToWindow$lambda2(BdAlertDialog.this, z);
                    }
                }
            });
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            NightModeHelper.unsubscribeNightModeChangedEvent(this);
        }
    }

    public final void initResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Resources resources = getContext().getResources();
            int color = resources.getColor(R.color.obfuscated_res_0x7f060373);
            int color2 = resources.getColor(R.color.obfuscated_res_0x7f060374);
            RelativeLayout relativeLayout = this.mDialogLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f080236, null));
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
                bdBaseImageView.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f080248, null));
            }
            BdBaseImageView bdBaseImageView2 = this.mBottomClose;
            if (bdBaseImageView2 != null) {
                bdBaseImageView2.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f080237, null));
            }
            View view2 = this.mDivider;
            if (view2 != null) {
                view2.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060377));
            }
        }
    }

    public final void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mTitlePanel = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092620);
            this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f0908f3);
            this.mMessage = (TextView) findViewById(R.id.obfuscated_res_0x7f0908e8);
            this.mMessageContent = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0908e9);
            this.mDialogContent = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0908de);
            this.mIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f0908e2);
            this.mDialogLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090391);
            this.mDialogCustomPanel = (RoundAngleFrameLayout) findViewById(R.id.obfuscated_res_0x7f0908dd);
            this.mBtnContainer = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091037);
            this.mBottomClose = (BdBaseImageView) findViewById(R.id.obfuscated_res_0x7f090473);
            this.mRightClose = (BdBaseImageView) findViewById(R.id.obfuscated_res_0x7f091f9c);
            this.mDivider = findViewById(R.id.obfuscated_res_0x7f09103b);
            this.mBtnHeight = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d7);
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

    public final void setCloseIconPosition(CancelXPosition cancelXPosition, Drawable drawable) {
        BdBaseImageView bdBaseImageView;
        BdBaseImageView bdBaseImageView2;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, cancelXPosition, drawable) == null) && cancelXPosition != null) {
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
                        bdBaseImageView9.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tj
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    BdAlertDialog.m32setCloseIconPosition$lambda4(BdAlertDialog.this, view2);
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
                bdBaseImageView12.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sj
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            BdAlertDialog.m31setCloseIconPosition$lambda3(BdAlertDialog.this, view2);
                        }
                    }
                });
            }
            if (drawable != null && (bdBaseImageView = this.mBottomClose) != null) {
                bdBaseImageView.setBackground(drawable);
            }
        }
    }

    public final void setMessage(CharSequence charSequence, Boolean bool, Integer num, Boolean bool2, Integer num2) {
        ViewGroup.LayoutParams layoutParams;
        TextView textView;
        TextView textView2;
        TextView textView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048592, this, charSequence, bool, num, bool2, num2) == null) {
            final Resources resources = getContext().getResources();
            TextView textView4 = this.mMessage;
            if (textView4 != null) {
                textView4.setText(charSequence);
            }
            TextView textView5 = this.mMessage;
            if (textView5 != null) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView5, 0, R.dimen.obfuscated_res_0x7f0701b3, 0, 4, null);
            }
            if (num2 != null && (textView3 = this.mMessage) != null) {
                textView3.setGravity(num2.intValue());
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
                    TextView textView6 = this.mMessage;
                    if (textView6 != null) {
                        textView6.setTextColor(getCompatibleColor(num.intValue()));
                    }
                } else {
                    TextView textView7 = this.mMessage;
                    if (textView7 != null) {
                        textView7.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060373));
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
                        layoutParams3.topMargin = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b0);
                        layoutParams3.bottomMargin = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701af);
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
                        TextView textView8 = this.mMessage;
                        if (textView8 != null) {
                            Builder builder2 = this.mBuilder;
                            Intrinsics.checkNotNull(builder2);
                            textView8.setMaxLines(builder2.getMMessageMaxLine$lib_dialog_release());
                        }
                    }
                }
                TextView textView9 = this.mMessage;
                if (textView9 != null) {
                    textView9.setMaxLines(12);
                }
            } else {
                Builder builder3 = this.mBuilder;
                if (builder3 != null) {
                    Intrinsics.checkNotNull(builder3);
                    if (builder3.getMMessageMaxLine$lib_dialog_release() > 0) {
                        TextView textView10 = this.mMessage;
                        if (textView10 != null) {
                            Builder builder4 = this.mBuilder;
                            Intrinsics.checkNotNull(builder4);
                            textView10.setMaxLines(builder4.getMMessageMaxLine$lib_dialog_release());
                        }
                    }
                }
                TextView textView11 = this.mMessage;
                if (textView11 != null) {
                    textView11.setMaxLines(8);
                }
            }
            TextView textView12 = this.mMessage;
            if (textView12 != null) {
                textView12.setLinkTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f0607be));
            }
            TextView textView13 = this.mMessage;
            if (textView13 != null) {
                textView13.setHighlightColor(0);
            }
            CustomLinkMovementMethod customLinkMovementMethod = new CustomLinkMovementMethod();
            customLinkMovementMethod.setLinkMovementListener(new CustomLinkMovementMethod.OnLinkMovementListener(this, resources) { // from class: com.baidu.android.ext.widget.dialog.BdAlertDialog$setMessage$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Resources $resources;
                public final /* synthetic */ BdAlertDialog this$0;

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
                        Object[] objArr = {this, resources};
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
                    this.$resources = resources;
                }

                @Override // com.baidu.searchbox.ui.CustomLinkMovementMethod.OnLinkMovementListener
                public void onNoLinkTouch(TextView widget, MotionEvent event) {
                    TextView textView14;
                    TextView textView15;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, widget, event) == null) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        Intrinsics.checkNotNullParameter(event, "event");
                        if (event.getAction() == 0) {
                            textView15 = this.this$0.mMessage;
                            if (textView15 != null) {
                                textView15.setLinkTextColor(this.$resources.getColor(R.color.obfuscated_res_0x7f06000a));
                                return;
                            }
                            return;
                        }
                        textView14 = this.this$0.mMessage;
                        if (textView14 != null) {
                            textView14.setLinkTextColor(AppCompatResources.getColorStateList(this.this$0.getContext(), R.color.obfuscated_res_0x7f0607be));
                        }
                    }
                }
            });
            TextView textView14 = this.mMessage;
            if (textView14 != null) {
                textView14.setMovementMethod(customLinkMovementMethod);
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, view2) == null) && (frameLayout = this.mDialogContent) != null) {
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
                ArrayList<ButtonItem> arrayList = this.mBtnItemList;
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
                            layoutParams3.addRule(3, R.id.obfuscated_res_0x7f0908dd);
                            FrameLayout frameLayout5 = this.mBtnContainer;
                            if (frameLayout5 != null) {
                                frameLayout5.setLayoutParams(layoutParams3);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        }
                    }
                    float dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701ac);
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
}
