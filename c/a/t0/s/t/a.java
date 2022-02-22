package c.a.t0.s.t;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_SIZE_BIG = 1;
    public static final int DIALOG_SIZE_FOR_FRS_LIKE_POSTER = 9;
    public static final int DIALOG_SIZE_FOR_NEW_PRIVATE = 7;
    public static final int DIALOG_SIZE_FOR_PRIVACY_POLICY_GUIDE = 8;
    public static final int DIALOG_SIZE_FOR_PRIVATE = 3;
    public static final int DIALOG_SIZE_PRIVATE = 2;
    public static final int DIALOG_SIZE_SMALL = 0;
    public static final int DIALOG_SIZW_PRIVACY_BUTTON = 6;
    public static final int DIALOG_SIZW_PUSH_PERMISSION = 4;
    public static final int DIALOG_SIZW_YOUNGSTER = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public int animRes;
    public View bdDialog_divider_line;
    public boolean cancelableFlag;
    public int dialogSize;
    public View dividerWithButton;
    public Handler handler;
    public TextView introTextView;
    public boolean isAutoNight;
    public boolean isMessageShowCenter;
    public boolean isOnlyMessageShowCenter;
    public boolean isTitleShowCenter;
    public final Activity mActivity;
    public int mButtonTextColorId;
    public DialogInterface.OnCancelListener mCancelListenr;
    public boolean mCancelable;
    public Button mCloseButton;
    public e mCloseButtonListener;
    public View mContentView;
    public AlertDialog mDialog;
    public boolean mDialogCreated;
    public int mDialogGravity;
    public DialogInterface.OnDismissListener mDismissListener;
    public String mMessage;
    public e mNegativeButtonListener;
    public String mNegativeButtonTip;
    public int mNegativeTextColorId;
    public DialogInterface.OnKeyListener mOnKeyListener;
    public e mPositiveButtonListener;
    public String mPositiveButtonTip;
    public ViewGroup mRealView;
    public final ViewGroup mRootView;
    public String mTitle;
    public TextView noButton;
    public TextView noTipAgain;
    public ImageView noTipAgainCheckBox;
    public boolean noTipAgainChecked;
    public f onNoTipAgainCheckListener;
    public TextView titleTextView;
    public boolean useNoTipAgainStyle;
    public TextView yesButton;
    public Object yesTag;

    /* renamed from: c.a.t0.s.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0903a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14024e;

        public View$OnClickListenerC0903a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14024e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f14024e;
                aVar.noTipAgainChecked = !aVar.noTipAgainChecked;
                this.f14024e.setCheckBoxDrawable();
                if (this.f14024e.onNoTipAgainCheckListener != null) {
                    this.f14024e.onNoTipAgainCheckListener.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;

        public b(a aVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view instanceof EditText) {
                    this.a.set(true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14025e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14025e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14025e.show(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a f14026e;

        /* renamed from: f  reason: collision with root package name */
        public final e f14027f;

        public d(a aVar, a aVar2, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14026e = aVar2;
            this.f14027f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (eVar = this.f14027f) == null) {
                return;
            }
            eVar.onClick(this.f14026e);
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void onClick(a aVar);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDialogGravity = -1;
        this.isOnlyMessageShowCenter = true;
        this.isMessageShowCenter = false;
        this.isTitleShowCenter = false;
        this.mButtonTextColorId = -1;
        this.mNegativeTextColorId = -1;
        this.dialogSize = 0;
        this.mDialogCreated = false;
        this.cancelableFlag = true;
        this.mCancelable = true;
        this.isAutoNight = true;
        this.useNoTipAgainStyle = false;
        this.noTipAgainChecked = false;
        this.animRes = -1;
        this.mActivity = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(c.a.u0.a4.h.dialog_bdalert, (ViewGroup) null);
        this.mRootView = viewGroup;
        this.mRealView = (ViewGroup) viewGroup.findViewById(c.a.u0.a4.g.real_view);
    }

    private void changeContentWithNoTipAgainSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            SkinManager.setViewTextColor(this.titleTextView, c.a.u0.a4.d.CAM_X0105);
            SkinManager.setViewTextColor(this.introTextView, c.a.u0.a4.d.CAM_X0107);
            setCheckBoxDrawable();
            SkinManager.setViewTextColor(this.noTipAgain, c.a.u0.a4.d.CAM_X0107);
            initButtonStyle();
        }
    }

    private void initButtonStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            TextView textView = this.noButton;
            if (textView != null) {
                c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(textView);
                d2.x(c.a.u0.a4.d.CAM_X0302);
                d2.n(c.a.u0.a4.j.J_X06);
                d2.f(c.a.u0.a4.d.CAM_X0211);
            }
            TextView textView2 = this.yesButton;
            if (textView2 != null) {
                c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(textView2);
                d3.x(c.a.u0.a4.d.CAM_X0302);
                d3.n(c.a.u0.a4.j.J_X06);
                d3.f(c.a.u0.a4.d.CAM_X0211);
            }
        }
    }

    private void mouldButtons(boolean z, boolean z2) {
        View view;
        View view2;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z && z2) {
                View view4 = this.dividerWithButton;
                if (view4 != null) {
                    view4.setVisibility(0);
                }
                View view5 = this.bdDialog_divider_line;
                if (view5 != null) {
                    view5.setVisibility(0);
                    return;
                }
                return;
            }
            if (isAutoNight()) {
                TbadkCoreApplication.getInst().getSkinType();
            }
            View view6 = this.dividerWithButton;
            if (view6 != null) {
                view6.setVisibility(8);
            }
            if (!z && !z2) {
                TextView textView = this.yesButton;
                if (textView == null || this.noButton == null || this.dividerWithButton == null || this.bdDialog_divider_line == null) {
                    return;
                }
                textView.setVisibility(8);
                this.noButton.setVisibility(8);
                this.dividerWithButton.setVisibility(8);
                this.bdDialog_divider_line.setVisibility(8);
            } else if (z) {
                c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.yesButton);
                d2.n(c.a.u0.a4.j.J_X06);
                d2.f(c.a.u0.a4.d.CAM_X0211);
                if (this.noButton == null || this.dividerWithButton == null || (view3 = this.bdDialog_divider_line) == null) {
                    return;
                }
                view3.setVisibility(0);
                this.yesButton.setVisibility(0);
                this.noButton.setVisibility(8);
            } else if (z2) {
                c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(this.noButton);
                d3.n(c.a.u0.a4.j.J_X06);
                d3.f(c.a.u0.a4.d.CAM_X0211);
                if (this.yesButton == null || this.dividerWithButton == null || (view2 = this.bdDialog_divider_line) == null) {
                    return;
                }
                view2.setVisibility(0);
                this.noButton.setVisibility(0);
                this.yesButton.setVisibility(8);
            } else if (this.yesButton == null || this.noButton == null || (view = this.bdDialog_divider_line) == null) {
            } else {
                view.setVisibility(8);
                this.yesButton.setVisibility(8);
                this.noButton.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckBoxDrawable() {
        ImageView imageView;
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (imageView = this.noTipAgainCheckBox) == null) {
            return;
        }
        if (this.noTipAgainChecked) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(c.a.u0.a4.f.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(c.a.u0.a4.f.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a show(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, this, z)) == null) {
            if (this.mDialogCreated) {
                AlertDialog alertDialog = this.mDialog;
                if (alertDialog != null) {
                    if (z) {
                        c.a.d.f.m.g.i(alertDialog, this.mActivity);
                    } else {
                        alertDialog.show();
                    }
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.mActivity).create();
                this.mDialog = create;
                create.setCanceledOnTouchOutside(this.cancelableFlag);
                this.mDialog.setCancelable(this.mCancelable);
                this.mDialog.setOnKeyListener(this.mOnKeyListener);
                DialogInterface.OnCancelListener onCancelListener = this.mCancelListenr;
                if (onCancelListener != null) {
                    this.mDialog.setOnCancelListener(onCancelListener);
                }
                DialogInterface.OnDismissListener onDismissListener = this.mDismissListener;
                if (onDismissListener != null) {
                    this.mDialog.setOnDismissListener(onDismissListener);
                }
                if (z) {
                    c.a.d.f.m.g.i(this.mDialog, this.mActivity);
                } else {
                    this.mDialog.show();
                }
                if (this.mDialog.getWindow().getDecorView().getParent() == null) {
                    return this;
                }
                Window window = this.mDialog.getWindow();
                if (this.mDialogGravity == -1) {
                    this.mDialogGravity = 17;
                }
                window.setGravity(this.mDialogGravity);
                window.setBackgroundDrawableResource(c.a.u0.a4.f.transparent_bg);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics q = c.a.d.f.p.n.q(this.mActivity);
                if (q != null) {
                    int dialogMargin = getDialogMargin();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = q.heightPixels - (dialogMargin * 2);
                    } else {
                        attributes.width = q.widthPixels - (dialogMargin * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ViewHelper.processAllViewsIn(this.mRootView, false, new b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
                int i2 = this.animRes;
                if (i2 != -1) {
                    window.setWindowAnimations(i2);
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (a) invokeZ.objValue;
    }

    public void autoChangeSkinType(@Nullable c.a.d.a.f<?> fVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().f13470e = !isAutoNight();
                tbPageContext.getLayoutMode().j(this.mRootView);
                if (this.mContentView != null) {
                    tbPageContext.getLayoutMode().j(this.mContentView);
                }
            }
            ViewGroup viewGroup = this.mRootView;
            if (viewGroup != null) {
                viewGroup.setBackgroundResource(c.a.u0.a4.f.transparent_bg);
            }
            if (this.mRealView != null && ((i2 = this.dialogSize) == 2 || i2 == 5 || i2 == 9)) {
                this.mRealView.setBackgroundResource(c.a.u0.a4.f.dialog_private_background);
            } else {
                SkinManager.setBackgroundResource(this.mRealView, c.a.u0.a4.f.dialog_background, skinType);
            }
            changeContentWithNoTipAgainSkinType();
        }
    }

    public a create(@Nullable c.a.d.a.f<?> fVar) {
        InterceptResult invokeL;
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.mDialogCreated) {
                return this;
            }
            boolean z2 = true;
            this.mDialogCreated = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(c.a.u0.a4.g.dialog_content);
            this.yesButton = (TextView) this.mRootView.findViewById(c.a.u0.a4.g.yes);
            this.noButton = (TextView) this.mRootView.findViewById(c.a.u0.a4.g.no);
            this.dividerWithButton = this.mRootView.findViewById(c.a.u0.a4.g.divider_yes_no_button);
            this.bdDialog_divider_line = this.mRootView.findViewById(c.a.u0.a4.g.bdDialog_divider_line);
            this.mCloseButton = (Button) this.mRootView.findViewById(c.a.u0.a4.g.close_btn);
            initButtonStyle();
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                if (this.mContentView.getParent() != null) {
                    if (this.mContentView.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                        linearLayout.addView(this.mContentView);
                    }
                } else {
                    linearLayout.addView(this.mContentView);
                }
            } else {
                View createContentViewWithNoTipAgain = this.useNoTipAgainStyle ? createContentViewWithNoTipAgain() : isShowTitleAndMessage();
                if (createContentViewWithNoTipAgain != null) {
                    linearLayout.removeAllViews();
                    if (createContentViewWithNoTipAgain.getParent() != null) {
                        if (createContentViewWithNoTipAgain.getParent() instanceof ViewGroup) {
                            ((ViewGroup) createContentViewWithNoTipAgain.getParent()).removeView(createContentViewWithNoTipAgain);
                            linearLayout.addView(createContentViewWithNoTipAgain);
                        }
                    } else {
                        linearLayout.addView(createContentViewWithNoTipAgain);
                    }
                }
            }
            autoChangeSkinType(fVar);
            if (this.mCloseButtonListener != null) {
                this.mCloseButton.setVisibility(0);
                this.mCloseButton.setOnClickListener(new d(this, this, this.mCloseButtonListener));
                SkinManager.setBackgroundResource(this.mCloseButton, c.a.u0.a4.f.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
            }
            if (this.mButtonTextColorId != -1) {
                TextView textView4 = this.yesButton;
                if (textView4 != null) {
                    c.a.t0.s.v.c.d(textView4).x(this.mButtonTextColorId);
                }
                TextView textView5 = this.noButton;
                if (textView5 != null) {
                    c.a.t0.s.v.c.d(textView5).x(this.mButtonTextColorId);
                }
            }
            if (this.mNegativeTextColorId != -1 && (textView3 = this.noButton) != null) {
                c.a.t0.s.v.c.d(textView3).x(this.mNegativeTextColorId);
            }
            if (TextUtils.isEmpty(this.mPositiveButtonTip) || (textView2 = this.yesButton) == null) {
                z = false;
            } else {
                textView2.setText(this.mPositiveButtonTip);
                this.yesButton.setTag(this.yesTag);
                e eVar = this.mPositiveButtonListener;
                if (eVar != null) {
                    this.yesButton.setOnClickListener(new d(this, this, eVar));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.mNegativeButtonTip) || (textView = this.noButton) == null) {
                z2 = false;
            } else {
                textView.setText(this.mNegativeButtonTip);
                e eVar2 = this.mNegativeButtonListener;
                if (eVar2 != null) {
                    this.noButton.setOnClickListener(new d(this, this, eVar2));
                }
            }
            mouldButtons(z, z2);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public View createContentViewWithNoTipAgain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(c.a.u0.a4.h.dialog_content_with_no_tip_again, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(c.a.u0.a4.g.title);
            this.titleTextView = textView;
            textView.setText(this.mTitle);
            TextView textView2 = (TextView) inflate.findViewById(c.a.u0.a4.g.intro);
            this.introTextView = textView2;
            textView2.setText(this.mMessage);
            this.noTipAgain = (TextView) inflate.findViewById(c.a.u0.a4.g.no_tip_again_text);
            this.noTipAgainCheckBox = (ImageView) inflate.findViewById(c.a.u0.a4.g.checkbox);
            setCheckBoxDrawable();
            this.noTipAgainCheckBox.setOnClickListener(new View$OnClickListenerC0903a(this));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alertDialog = this.mDialog) == null) {
            return;
        }
        c.a.d.f.m.g.a(alertDialog, this.mActivity);
    }

    public Dialog getDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDialog : (Dialog) invokeV.objValue;
    }

    public int getDialogMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = c.a.u0.a4.e.tbds0;
            int i3 = this.dialogSize;
            if (i3 == 0) {
                i2 = c.a.u0.a4.e.ds90;
            } else if (i3 == 1) {
                i2 = c.a.u0.a4.e.ds40;
            } else if (i3 == 2 || i3 == 6) {
                i2 = c.a.u0.a4.e.tbds44;
            } else if (i3 == 3) {
                i2 = c.a.u0.a4.e.tbds45;
            } else if (i3 == 4 || i3 == 5) {
                i2 = c.a.u0.a4.e.tbds50;
            } else if (i3 == 7) {
                i2 = c.a.u0.a4.e.tbds206;
            } else if (i3 == 8 || i3 == 9) {
                i2 = c.a.u0.a4.e.tbds120;
            }
            return c.a.d.f.p.n.f(this.mActivity, i2);
        }
        return invokeV.intValue;
    }

    public DialogInterface.OnKeyListener getOnKeyListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOnKeyListener : (DialogInterface.OnKeyListener) invokeV.objValue;
    }

    public ViewGroup getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRealView : (ViewGroup) invokeV.objValue;
    }

    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mDialog.getWindow() : (Window) invokeV.objValue;
    }

    public Object getYesButtonTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.yesTag : invokeV.objValue;
    }

    public void hide() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (alertDialog = this.mDialog) == null) {
            return;
        }
        alertDialog.hide();
    }

    public boolean isAutoNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isAutoNight : invokeV.booleanValue;
    }

    public boolean isNoTipAgainChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.noTipAgainChecked : invokeV.booleanValue;
    }

    public View isShowTitleAndMessage() {
        InterceptResult invokeV;
        LinearLayout linearLayout;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            boolean z = !StringUtils.isNull(this.mTitle);
            boolean z2 = !StringUtils.isNull(this.mMessage);
            TextView textView2 = null;
            if (z || z2) {
                if (z && z2) {
                    linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(c.a.u0.a4.h.bdalert_two_message_view, (ViewGroup) null);
                    textView2 = (TextView) linearLayout.findViewById(c.a.u0.a4.g.title_view);
                    textView = (TextView) linearLayout.findViewById(c.a.u0.a4.g.message_view);
                    if (this.isMessageShowCenter) {
                        textView2.setGravity(17);
                        textView.setGravity(17);
                    }
                    if (this.isTitleShowCenter) {
                        textView2.setGravity(17);
                    }
                    textView2.setText(this.mTitle);
                    textView.setText(this.mMessage);
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(c.a.u0.a4.h.bdalert_one_message_view, (ViewGroup) null);
                    TextView textView3 = (TextView) linearLayout2.findViewById(c.a.u0.a4.g.message_view);
                    if (z) {
                        textView3.setText(this.mTitle);
                    } else {
                        if (this.isOnlyMessageShowCenter) {
                            textView3.setGravity(17);
                        }
                        textView3.setText(this.mMessage);
                    }
                    linearLayout = linearLayout2;
                    textView = textView3;
                }
                SkinManager.setViewTextColor(textView2, c.a.u0.a4.d.CAM_X0105);
                SkinManager.setViewTextColor(textView, c.a.u0.a4.d.CAM_X0105);
                return linearLayout;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AlertDialog alertDialog = this.mDialog;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mDialogCreated = false;
        }
    }

    public void setAnimRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.animRes = i2;
        }
    }

    public void setAutoNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.isAutoNight = z;
        }
    }

    public a setButtonTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.mButtonTextColorId = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a setCancelable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            this.mCancelable = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a setCanceledOnTouchOutside(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.cancelableFlag = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a setCloseButton(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, eVar)) == null) {
            if (eVar != null) {
                this.mCloseButtonListener = eVar;
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a setContentView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view)) == null) {
            this.mContentView = view;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a setContentViewId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mContentView = LayoutInflater.from(activity).inflate(i2, (ViewGroup) null);
            }
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a setContentViewSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.dialogSize = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a setGravity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.mDialogGravity = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a setMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.mMessage = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a setMessageId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mMessage = activity.getResources().getString(i2);
            }
            return this;
        }
        return (a) invokeI.objValue;
    }

    public void setMessageShowCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.isMessageShowCenter = z;
        }
    }

    public a setNegativeButton(String str, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, str, eVar)) == null) {
            this.mNegativeButtonTip = str;
            this.mNegativeButtonListener = eVar;
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public a setNegativeTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            this.mNegativeTextColorId = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public void setNoBtnClickable(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z) == null) || (textView = this.noButton) == null) {
            return;
        }
        textView.setClickable(z);
    }

    public a setOnCalcelListener(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, onCancelListener)) == null) {
            this.mCancelListenr = onCancelListener;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, onDismissListener)) == null) {
            this.mDismissListener = onDismissListener;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onKeyListener) == null) {
            this.mOnKeyListener = onKeyListener;
        }
    }

    public void setOnNoTipAgainCheckListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, fVar) == null) {
            this.onNoTipAgainCheckListener = fVar;
        }
    }

    public void setOnlyMessageShowCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.isOnlyMessageShowCenter = z;
        }
    }

    public a setPositiveButton(String str, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, str, eVar)) == null) {
            this.mPositiveButtonTip = str;
            this.mPositiveButtonListener = eVar;
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public void setRealView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, viewGroup) == null) {
            this.mRealView = viewGroup;
        }
    }

    public a setTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            this.mTitle = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void setTitleShowCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.isTitleShowCenter = z;
        }
    }

    public void setUseNoTipAgainStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.useNoTipAgainStyle = z;
        }
    }

    public void setYesBtnClickable(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048621, this, z) == null) || (textView = this.yesButton) == null) {
            return;
        }
        textView.setClickable(z);
    }

    public void setYesButtonTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, obj) == null) {
            this.yesTag = obj;
        }
    }

    public a showNoCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? show(false) : (a) invokeV.objValue;
    }

    public a setTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            setTitle(this.mActivity.getResources().getString(i2));
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a setNegativeButton(int i2, e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i2, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mNegativeButtonTip = activity.getResources().getString(i2);
                this.mNegativeButtonListener = eVar;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a setPositiveButton(int i2, e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i2, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mPositiveButtonTip = activity.getResources().getString(i2);
                this.mPositiveButtonListener = eVar;
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a show() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? show(true) : (a) invokeV.objValue;
    }

    public void show(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j2) == null) {
            Handler handler = new Handler();
            this.handler = handler;
            handler.postDelayed(new c(this), j2);
        }
    }
}
