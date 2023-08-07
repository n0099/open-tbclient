package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TBAlertBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity activity;
    public View.OnClickListener bottomCloseBtnClick;
    public final AlertDialog.Builder builder;
    public View customContentView;
    public View customHeaderView;
    public int descGravity;
    public boolean descLightStyle;
    public MovementMethod descMovementMethod;
    public CharSequence descStr;
    public AlertDialog dialog;
    public View.OnClickListener dismissClick;
    public boolean hasCreated;
    public z45 mTBAlertWidget;
    public LinearLayout mainLayout;
    public boolean needTransparentBg;
    public boolean operateBtnAutoClose;
    public TBAlertConfig.a operateConfig;
    public boolean showBottomCloseBtn;
    public CharSequence subTitleStr;
    public CharSequence titleStr;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ View b;

        public a(TBAlertBuilder tBAlertBuilder, TextView textView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBAlertBuilder, textView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textView;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UtilHelper.getDimenPixelSize(R.dimen.tbds868) == this.a.getHeight()) {
                this.b.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;

        public b(TBAlertBuilder tBAlertBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBAlertBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBAlertBuilder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.dialog != null) {
                    this.a.dialog.dismiss();
                }
                if (this.a.bottomCloseBtnClick != null) {
                    this.a.bottomCloseBtnClick.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;

        public c(TBAlertBuilder tBAlertBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBAlertBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBAlertBuilder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.dialog != null) {
                this.a.dialog.dismiss();
            }
        }
    }

    public TBAlertBuilder(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.descGravity = 17;
        this.descMovementMethod = ScrollingMovementMethod.getInstance();
        this.activity = activity;
        this.builder = new AlertDialog.Builder(activity);
        this.mTBAlertWidget = new z45();
    }

    public static void handleDialogBackground(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dialog) != null) || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(17170445);
    }

    public static void handleDialogWidth(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, dialog) != null) || (window = dialog.getWindow()) == null) {
            return;
        }
        Context context = dialog.getContext();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = processWidth(context);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(attributes);
    }

    public static int processWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            int i = context.getResources().getDisplayMetrics().widthPixels;
            int i2 = (i * 837) / 1076;
            int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds756);
            if (i2 < dimens) {
                return Math.min(i, dimens);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public TBAlertBuilder setBottomCloseBtnClick(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, onClickListener)) == null) {
            this.bottomCloseBtnClick = onClickListener;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder setCancelable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.builder.setCancelable(z);
            return this;
        }
        return (TBAlertBuilder) invokeZ.objValue;
    }

    public TBAlertBuilder setCustomContentView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            this.customContentView = view2;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder setCustomHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            this.customHeaderView = view2;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder setDesc(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.descStr = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (TBAlertBuilder) invokeI.objValue;
    }

    public TBAlertBuilder setDescGravity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            this.descGravity = i;
            return this;
        }
        return (TBAlertBuilder) invokeI.objValue;
    }

    public TBAlertBuilder setDescLightStyle(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.descLightStyle = z;
            return this;
        }
        return (TBAlertBuilder) invokeZ.objValue;
    }

    public TBAlertBuilder setDescMovementMethod(MovementMethod movementMethod) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, movementMethod)) == null) {
            this.descMovementMethod = movementMethod;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder setDescStr(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, charSequence)) == null) {
            this.descStr = charSequence;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder setNeedTransparentBg(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            this.needTransparentBg = z;
            return this;
        }
        return (TBAlertBuilder) invokeZ.objValue;
    }

    public TBAlertBuilder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, onDismissListener)) == null) {
            this.builder.setOnDismissListener(onDismissListener);
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, onKeyListener)) == null) {
            this.builder.setOnKeyListener(onKeyListener);
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder setOperateConfig(TBAlertConfig.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, aVar)) == null) {
            this.operateConfig = aVar;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public TBAlertBuilder setShowBottomCloseBtn(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.showBottomCloseBtn = z;
            return this;
        }
        return (TBAlertBuilder) invokeZ.objValue;
    }

    public TBAlertBuilder setSubTitle(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            this.subTitleStr = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (TBAlertBuilder) invokeI.objValue;
    }

    public TBAlertBuilder setTitle(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            this.titleStr = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (TBAlertBuilder) invokeI.objValue;
    }

    public TBAlertBuilder setTitleStr(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
            this.titleStr = charSequence;
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }

    public AlertDialog show(AlertDialog alertDialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, alertDialog)) == null) {
            GreyUtil.grey(alertDialog);
            alertDialog.show();
            handleDialogBackground(alertDialog);
            handleDialogWidth(alertDialog);
            return alertDialog;
        }
        return (AlertDialog) invokeL.objValue;
    }

    private void changeMainLayoutView(View view2, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, view2, z) == null) {
            EMManager from = EMManager.from(view2);
            if (this.customHeaderView == null) {
                i = 0;
            } else {
                i = 2;
            }
            EMManager corner = from.setCardType(i).setCorner(R.string.J_X06);
            if (z) {
                i2 = R.color.transparent;
            } else {
                i2 = R.color.CAM_X0205;
            }
            corner.setBackGroundColor(i2);
        }
    }

    private void setupView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View view2 = this.customHeaderView;
            if (view2 != null) {
                if (view2.getLayoutParams() == null) {
                    linearLayout.addView(this.customHeaderView, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    linearLayout.addView(this.customHeaderView);
                }
            }
            LinearLayout linearLayout2 = new LinearLayout(this.activity);
            this.mainLayout = linearLayout2;
            linearLayout2.setOrientation(1);
            this.mainLayout.setGravity(17);
            this.mainLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            changeMainLayoutView(this.mainLayout, this.needTransparentBg);
            if (!TextUtils.isEmpty(this.titleStr)) {
                TextView m = this.mTBAlertWidget.m(this.activity);
                m.setText(this.titleStr);
                m.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X009), UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                this.mainLayout.addView(m);
                CharSequence charSequence = this.subTitleStr;
                if (charSequence != null && !StringUtils.isNull(charSequence.toString())) {
                    m.setPadding(m.getPaddingLeft(), m.getPaddingTop(), m.getPaddingRight(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                    TextView m2 = this.mTBAlertWidget.m(this.activity);
                    m2.setText(this.subTitleStr);
                    m2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                    this.mainLayout.addView(m2);
                }
            }
            if (!TextUtils.isEmpty(this.descStr)) {
                RelativeLayout relativeLayout = new RelativeLayout(this.activity);
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView c2 = this.mTBAlertWidget.c(this.activity, this.descLightStyle);
                c2.setText(this.descStr);
                c2.setGravity(this.descGravity);
                c2.setId(R.id.obfuscated_res_0x7f090881);
                c2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0);
                c2.setMaxHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds868));
                c2.setMovementMethod(this.descMovementMethod);
                relativeLayout.addView(c2, new ViewGroup.LayoutParams(-1, -2));
                View view3 = new View(this.activity);
                view3.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
                layoutParams.addRule(8, R.id.obfuscated_res_0x7f090881);
                SkinManager.setBackgroundColorToTransparent(view3, R.color.CAM_X0205, GradientDrawable.Orientation.BOTTOM_TOP);
                relativeLayout.addView(view3, layoutParams);
                this.mainLayout.addView(relativeLayout);
                c2.post(new a(this, c2, view3));
            }
            View view4 = this.customContentView;
            if (view4 != null) {
                if (view4.getLayoutParams() == null) {
                    this.mainLayout.addView(this.customContentView, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    this.mainLayout.addView(this.customContentView);
                }
            }
            if (this.operateConfig != null) {
                if (this.operateBtnAutoClose) {
                    this.dismissClick = new b(this);
                }
                this.mainLayout.addView(this.mTBAlertWidget.k(this.activity, this.operateConfig, this.dismissClick));
            }
            linearLayout.addView(this.mainLayout, new ViewGroup.LayoutParams(-1, -2));
            if (this.showBottomCloseBtn) {
                ImageView imageView = new ImageView(this.activity);
                imageView.setImageResource(R.drawable.icon_mask_pop_close);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104), BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds105));
                layoutParams2.setMargins(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X010), 0, 0);
                imageView.setOnClickListener(new c(this));
                linearLayout.addView(imageView, layoutParams2);
            }
            this.builder.setView(linearLayout);
        }
    }

    public AlertDialog create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.hasCreated) {
                this.hasCreated = true;
                setupView();
                this.dialog = this.builder.create();
            }
            return this.dialog;
        }
        return (AlertDialog) invokeV.objValue;
    }

    @Keep
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (alertDialog = this.dialog) != null) {
            alertDialog.dismiss();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            changeMainLayoutView(this.mainLayout, this.needTransparentBg);
            this.mTBAlertWidget.h();
        }
    }

    public TBAlertBuilder setAutoClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.operateBtnAutoClose = true;
            return this;
        }
        return (TBAlertBuilder) invokeV.objValue;
    }

    public AlertDialog show() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return show(create());
        }
        return (AlertDialog) invokeV.objValue;
    }

    public TBAlertBuilder setOperateBtn(TBAlertConfig.OperateBtnConfig... operateBtnConfigArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, operateBtnConfigArr)) == null) {
            int length = operateBtnConfigArr.length;
            if (length != 1) {
                if (length != 2) {
                    if (length == 3) {
                        this.operateConfig = TBAlertConfig.b(operateBtnConfigArr[0], operateBtnConfigArr[1], operateBtnConfigArr[2]);
                    }
                } else {
                    this.operateConfig = TBAlertConfig.c(operateBtnConfigArr[0], operateBtnConfigArr[1]);
                }
            } else {
                this.operateConfig = TBAlertConfig.a(operateBtnConfigArr[0]);
            }
            return this;
        }
        return (TBAlertBuilder) invokeL.objValue;
    }
}
