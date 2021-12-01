package com.baidu.poly.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c.a.f0.g;
import c.a.f0.h;
import c.a.f0.j;
import c.a.f0.s.e.a;
import c.a.f0.t.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.coupon.CouponListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class CouponListDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CouponListView f38418e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f38419f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f38420g;

    /* renamed from: h  reason: collision with root package name */
    public d f38421h;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListDialog f38422e;

        public a(CouponListDialog couponListDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38422e = couponListDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f38422e.f38418e != null && this.f38422e.f38421h != null) {
                    this.f38422e.f38421h.a(false, this.f38422e.f38418e.getSelectedItem());
                }
                this.f38422e.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CouponListDialog f38423e;

        public b(CouponListDialog couponListDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38423e = couponListDialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f38423e.f38418e == null || this.f38423e.f38421h == null) {
                return;
            }
            this.f38423e.f38421h.a(false, this.f38423e.f38418e.getSelectedItem());
        }
    }

    /* loaded from: classes9.dex */
    public class c implements CouponListView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CouponListDialog a;

        public c(CouponListDialog couponListDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponListDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = couponListDialog;
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void b(a.C0119a c0119a, c.a.f0.s.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0119a, aVar) == null) {
                a.C0116a c0116a = new a.C0116a();
                c0116a.a = 0;
                aVar.a(c0116a);
            }
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void c(boolean z, a.C0119a c0119a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, c0119a) == null) {
                this.a.dismiss();
                if (this.a.f38421h != null) {
                    this.a.f38421h.a(z, c0119a);
                }
            }
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void onDetach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(boolean z, a.C0119a c0119a);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CouponListDialog(Context context) {
        this(context, j.CashierSDK_CommonDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setContentView(h.dialog_couponlist_cashiersdk);
            Window window = getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setWindowAnimations(j.cashier_coupon_dialog_anim);
                window.setLayout(-1, -2);
            }
            this.f38418e = (CouponListView) findViewById(g.cashier_couponlist_view);
            FrameLayout frameLayout = (FrameLayout) findViewById(g.cashier_fl_title_content);
            this.f38420g = frameLayout;
            frameLayout.setVisibility(8);
            ImageView imageView = (ImageView) findViewById(g.iv_close);
            this.f38419f = imageView;
            imageView.setOnClickListener(new a(this));
            setOnCancelListener(new b(this));
        }
    }

    public void setListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f38421h = dVar;
        }
    }

    public void update(List<a.C0119a> list) {
        CouponListView couponListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (couponListView = this.f38418e) == null) {
            return;
        }
        couponListView.update(list);
        this.f38418e.setListener(new c(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponListDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }
}
