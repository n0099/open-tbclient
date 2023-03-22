package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ch6;
import com.baidu.tieba.gi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class WriteTipBubbleController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ch6 b;
    public b c;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2, String str);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public ANCHOR_VIEW_FROM(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ANCHOR_VIEW_FROM) Enum.valueOf(ANCHOR_VIEW_FROM.class, str);
            }
            return (ANCHOR_VIEW_FROM) invokeL.objValue;
        }

        public static ANCHOR_VIEW_FROM[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ANCHOR_VIEW_FROM[]) $VALUES.clone();
            }
            return (ANCHOR_VIEW_FROM[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ WriteTipBubbleController b;

        public a(WriteTipBubbleController writeTipBubbleController, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeTipBubbleController, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = writeTipBubbleController;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.c != null) {
                this.b.c.a(view2, this.a);
                if (this.b.b != null && this.b.b.e()) {
                    this.b.b.d();
                }
            }
        }
    }

    public WriteTipBubbleController(TbPageContext tbPageContext, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.c = bVar;
    }

    public void c() {
        ch6 ch6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ch6Var = this.b) != null) {
            ch6Var.d();
        }
    }

    public void d(@NonNull View view2, @NonNull String str, @NonNull String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, str, str2, anchor_view_from) == null) && this.a != null && view2 != null && !gi.isEmpty(str) && !gi.isEmpty(str2)) {
            if (this.b == null) {
                ch6 ch6Var = new ch6(this.a, view2);
                this.b = ch6Var;
                ch6Var.C(R.drawable.pic_post_findlink);
                this.b.o(2);
                this.b.m(true);
                this.b.B(19);
                this.b.t(R.color.CAM_X0105);
                this.b.j(5000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.b.k(32);
                this.b.h(2);
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
                this.b.v(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.b.H(0);
                this.b.I(-dimensionPixelSize2);
                this.b.l(R.dimen.tbds177);
                this.b.G(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.b.k(32);
                this.b.h(5);
                int dimensionPixelSize3 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.b.v(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.b.H(0);
                this.b.I(-dimensionPixelSize4);
                this.b.l(R.dimen.tbds177);
                this.b.G(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
                int dimensionPixelSize5 = this.a.getResources().getDimensionPixelSize(R.dimen.M_W_X006);
                int dimensionPixelSize6 = this.a.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                int dimensionPixelSize7 = this.a.getResources().getDimensionPixelSize(R.dimen.M_H_X006);
                this.b.C(R.drawable.bg_tip_blue_down);
                this.b.o(1);
                this.b.k(16);
                this.b.h(2);
                this.b.A(R.dimen.T_X08);
                this.b.t(R.color.CAM_X0101);
                int dimensionPixelSize8 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
                this.b.v(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize7);
                this.b.H(0);
                this.b.I(-dimensionPixelSize8);
                this.b.l(R.dimen.tbds112);
                this.b.G(R.dimen.tbds536);
            }
            this.b.i(new a(this, str2));
            this.b.J(str);
            TiebaStatic.log("c13801");
        }
    }
}
