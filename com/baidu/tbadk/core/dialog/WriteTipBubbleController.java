package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
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
import com.repackage.ki;
import com.repackage.zx5;
/* loaded from: classes3.dex */
public class WriteTipBubbleController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public zx5 b;
    public b c;

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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ANCHOR_VIEW_FROM) Enum.valueOf(ANCHOR_VIEW_FROM.class, str) : (ANCHOR_VIEW_FROM) invokeL.objValue;
        }

        public static ANCHOR_VIEW_FROM[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ANCHOR_VIEW_FROM[]) $VALUES.clone() : (ANCHOR_VIEW_FROM[]) invokeV.objValue;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.c == null) {
                return;
            }
            this.b.c.a(view2, this.a);
            if (this.b.b == null || !this.b.b.J()) {
                return;
            }
            this.b.b.I();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2, String str);
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
        zx5 zx5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (zx5Var = this.b) == null) {
            return;
        }
        zx5Var.I();
    }

    public void d(@NonNull View view2, @NonNull String str, @NonNull String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, str, str2, anchor_view_from) == null) || this.a == null || view2 == null || ki.isEmpty(str) || ki.isEmpty(str2)) {
            return;
        }
        if (this.b == null) {
            zx5 zx5Var = new zx5(this.a, view2);
            this.b = zx5Var;
            zx5Var.g0(R.drawable.pic_post_findlink);
            this.b.S(2);
            this.b.Q(true);
            this.b.f0(19);
            this.b.X(R.color.CAM_X0105);
            this.b.N(5000);
        }
        if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
            this.b.O(32);
            this.b.L(2);
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
            this.b.Z(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
            this.b.j0(0);
            this.b.k0(-dimensionPixelSize2);
            this.b.P(R.dimen.tbds177);
            this.b.i0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
            this.b.O(32);
            this.b.L(5);
            int dimensionPixelSize3 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize4 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            this.b.Z(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
            this.b.j0(0);
            this.b.k0(-dimensionPixelSize4);
            this.b.P(R.dimen.tbds177);
            this.b.i0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
            int dimensionPixelSize5 = this.a.getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            int dimensionPixelSize6 = this.a.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            int dimensionPixelSize7 = this.a.getResources().getDimensionPixelSize(R.dimen.M_H_X006);
            this.b.g0(R.drawable.obfuscated_res_0x7f0802e8);
            this.b.S(1);
            this.b.O(16);
            this.b.L(2);
            this.b.e0(R.dimen.T_X08);
            this.b.X(R.color.CAM_X0101);
            int dimensionPixelSize8 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
            this.b.Z(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize7);
            this.b.j0(0);
            this.b.k0(-dimensionPixelSize8);
            this.b.P(R.dimen.tbds112);
            this.b.i0(R.dimen.tbds536);
        }
        this.b.M(new a(this, str2));
        this.b.l0(str);
        TiebaStatic.log("c13801");
    }
}
