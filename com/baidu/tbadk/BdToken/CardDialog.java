package com.baidu.tbadk.BdToken;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.a.d.a.f;
import c.a.d.f.m.b;
import c.a.d.f.m.g;
import c.a.u0.a4.d;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class CardDialog extends Dialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f40302e;

    /* renamed from: f  reason: collision with root package name */
    public f f40303f;

    /* renamed from: g  reason: collision with root package name */
    public float f40304g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f40305h;

    /* renamed from: i  reason: collision with root package name */
    public RoundRelativeLayout f40306i;

    /* renamed from: j  reason: collision with root package name */
    public View f40307j;
    public ImageView k;
    public ImageView l;
    public Drawable m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDialog(f fVar) {
        super(fVar.getPageActivity(), 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40304g = 0.33f;
        this.f40303f = fVar;
        this.f40302e = fVar.getPageActivity();
    }

    public void dismissDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g.b(this, this.f40303f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && view.getId() == c.a.u0.a4.g.img_btn_close) {
            dismissDialog();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(h.dialog_card_main);
            Display defaultDisplay = ((WindowManager) this.f40302e.getSystemService("window")).getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setBackgroundDrawableResource(d.transparent);
            getWindow().setDimAmount(this.f40304g);
            getWindow().setGravity(80);
            getWindow().setWindowAnimations(0);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            this.f40305h = (ViewGroup) findViewById(c.a.u0.a4.g.card_root_layout);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(c.a.u0.a4.g.round_corner_layout);
            this.f40306i = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(b.d(TbadkCoreApplication.getInst().getString(j.J_X06), 31.0f));
            ViewGroup.LayoutParams layoutParams = this.f40307j.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
                layoutParams.width = -1;
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            this.f40306i.addView(this.f40307j, layoutParams);
            ImageView imageView = (ImageView) findViewById(c.a.u0.a4.g.img_bg);
            this.k = imageView;
            imageView.setImageDrawable(this.m);
            ImageView imageView2 = (ImageView) findViewById(c.a.u0.a4.g.img_btn_close);
            this.l = imageView2;
            imageView2.setOnClickListener(this);
        }
    }

    public void setContentBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, drawable) == null) {
            this.m = drawable;
        }
    }

    public void setRealView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) {
            this.f40307j = viewGroup;
        }
    }

    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (isShowing()) {
                g.b(this, this.f40303f);
            }
            g.j(this, this.f40303f);
        }
    }
}
