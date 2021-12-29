package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.d.f.p.m;
import c.a.t0.k0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class WriteTipBubbleController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public g f41627b;

    /* renamed from: c  reason: collision with root package name */
    public b f41628c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class ANCHOR_VIEW_FROM {
        public static final /* synthetic */ ANCHOR_VIEW_FROM[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ANCHOR_VIEW_FROM FROM_EDITOR_TOOL;
        public static final ANCHOR_VIEW_FROM FROM_EDIT_TEXT;
        public static final ANCHOR_VIEW_FROM FROM_PB_REPLY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1555981925, "Lcom/baidu/tbadk/core/dialog/WriteTipBubbleController$ANCHOR_VIEW_FROM;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1555981925, "Lcom/baidu/tbadk/core/dialog/WriteTipBubbleController$ANCHOR_VIEW_FROM;");
                    return;
                }
            }
            FROM_EDITOR_TOOL = new ANCHOR_VIEW_FROM("FROM_EDITOR_TOOL", 0);
            FROM_EDIT_TEXT = new ANCHOR_VIEW_FROM("FROM_EDIT_TEXT", 1);
            ANCHOR_VIEW_FROM anchor_view_from = new ANCHOR_VIEW_FROM("FROM_PB_REPLY", 2);
            FROM_PB_REPLY = anchor_view_from;
            $VALUES = new ANCHOR_VIEW_FROM[]{FROM_EDITOR_TOOL, FROM_EDIT_TEXT, anchor_view_from};
        }

        public ANCHOR_VIEW_FROM(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ANCHOR_VIEW_FROM valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ANCHOR_VIEW_FROM) Enum.valueOf(ANCHOR_VIEW_FROM.class, str) : (ANCHOR_VIEW_FROM) invokeL.objValue;
        }

        public static ANCHOR_VIEW_FROM[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ANCHOR_VIEW_FROM[]) $VALUES.clone() : (ANCHOR_VIEW_FROM[]) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41629e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WriteTipBubbleController f41630f;

        public a(WriteTipBubbleController writeTipBubbleController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeTipBubbleController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41630f = writeTipBubbleController;
            this.f41629e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41630f.f41628c == null) {
                return;
            }
            this.f41630f.f41628c.a(view, this.f41629e);
            if (this.f41630f.f41627b == null || !this.f41630f.f41627b.J()) {
                return;
            }
            this.f41630f.f41627b.I();
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(View view, String str);
    }

    public WriteTipBubbleController(TbPageContext tbPageContext, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f41628c = bVar;
    }

    public void c() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f41627b) == null) {
            return;
        }
        gVar.I();
    }

    public void d(@NonNull View view, @NonNull String str, @NonNull String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, str, str2, anchor_view_from) == null) || this.a == null || view == null || m.isEmpty(str) || m.isEmpty(str2)) {
            return;
        }
        if (this.f41627b == null) {
            g gVar = new g(this.a, view);
            this.f41627b = gVar;
            gVar.g0(R.drawable.pic_post_findlink);
            this.f41627b.S(2);
            this.f41627b.Q(true);
            this.f41627b.f0(19);
            this.f41627b.X(R.color.CAM_X0105);
            this.f41627b.N(5000);
        }
        if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
            this.f41627b.O(32);
            this.f41627b.L(2);
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f41627b.Z(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
            this.f41627b.j0(0);
            this.f41627b.k0(-dimensionPixelSize2);
            this.f41627b.P(R.dimen.tbds177);
            this.f41627b.i0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
            this.f41627b.O(32);
            this.f41627b.L(5);
            int dimensionPixelSize3 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize4 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            this.f41627b.Z(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
            this.f41627b.j0(0);
            this.f41627b.k0(-dimensionPixelSize4);
            this.f41627b.P(R.dimen.tbds177);
            this.f41627b.i0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
            int dimensionPixelSize5 = this.a.getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            int dimensionPixelSize6 = this.a.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            int dimensionPixelSize7 = this.a.getResources().getDimensionPixelSize(R.dimen.M_H_X006);
            this.f41627b.g0(R.drawable.bg_tip_blue_down);
            this.f41627b.S(1);
            this.f41627b.O(16);
            this.f41627b.L(2);
            this.f41627b.e0(R.dimen.T_X08);
            this.f41627b.X(R.color.CAM_X0101);
            int dimensionPixelSize8 = this.a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f41627b.Z(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize7);
            this.f41627b.j0(0);
            this.f41627b.k0(-dimensionPixelSize8);
            this.f41627b.P(R.dimen.tbds112);
            this.f41627b.i0(R.dimen.tbds536);
        }
        this.f41627b.M(new a(this, str2));
        this.f41627b.l0(str);
        TiebaStatic.log("c13801");
    }
}
