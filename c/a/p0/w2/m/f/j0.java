package c.a.p0.w2.m.f;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class j0 extends c.a.o0.r.t.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TbPageContext<?> w;
    public View.OnClickListener x;

    /* loaded from: classes3.dex */
    public class a implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j0 a;

        public a(j0 j0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j0Var;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                this.a.dismiss();
                this.a.x.onClick(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = tbPageContext;
        this.x = onClickListener;
        r();
    }

    public TextView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public TextView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (TextView) invokeV.objValue;
    }

    public TextView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.u : (TextView) invokeV.objValue;
    }

    public TextView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public TextView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : (TextView) invokeV.objValue;
    }

    public TextView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : (TextView) invokeV.objValue;
    }

    public View G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h() : (View) invokeV.objValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m.setVisibility(z ? 0 : 8);
        }
    }

    public void p(SparseArray<Object> sparseArray, int i, boolean z, c.a.p0.w2.i.u uVar) {
        TbPageContext<?> tbPageContext;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{sparseArray, Integer.valueOf(i), Boolean.valueOf(z), uVar}) == null) || sparseArray == null) {
            return;
        }
        PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69);
        if (postData.q() != null) {
            boolean z2 = postData.q().hasAgree;
            int r = postData.r();
            if (z2 && r == 5) {
                tbPageContext = this.w;
                i2 = R.string.obfuscated_res_0x7f0f0083;
            } else {
                tbPageContext = this.w;
                i2 = R.string.obfuscated_res_0x7f0f0085;
            }
            String string = tbPageContext.getString(i2);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.obfuscated_res_0x7f091e69, postData);
            v().setTag(sparseArray2);
            v().setVisibility(0);
            v().setText(string);
        }
        boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091e81) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e81)).booleanValue() : false;
        String str = sparseArray.get(R.id.obfuscated_res_0x7f091e79) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e79) : null;
        if (booleanValue) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
            sparseArray3.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
            sparseArray3.put(R.id.obfuscated_res_0x7f091e76, sparseArray.get(R.id.obfuscated_res_0x7f091e76));
            sparseArray3.put(R.id.obfuscated_res_0x7f091e77, sparseArray.get(R.id.obfuscated_res_0x7f091e77));
            sparseArray3.put(R.id.obfuscated_res_0x7f091e78, sparseArray.get(R.id.obfuscated_res_0x7f091e78));
            sparseArray3.put(R.id.obfuscated_res_0x7f091e79, str);
            if (!c.a.p0.w2.m.f.n1.a.i(uVar) && booleanValue2) {
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                sparseArray3.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                sparseArray3.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                sparseArray3.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
            } else {
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
            }
            if (booleanValue3) {
                sparseArray3.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                sparseArray3.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue4));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                if (booleanValue5) {
                    u().setVisibility(0);
                } else {
                    u().setVisibility(8);
                }
            } else {
                sparseArray3.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                u().setVisibility(8);
            }
            z().setTag(sparseArray3);
            u().setTag(sparseArray3);
            z().setText(R.string.obfuscated_res_0x7f0f02d3);
            z().setVisibility(0);
        } else if (booleanValue3) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
            sparseArray4.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
            sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
            sparseArray4.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue4));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
            z().setTag(sparseArray4);
            u().setTag(sparseArray4);
            z().setText(R.string.obfuscated_res_0x7f0f048e);
            u().setVisibility(0);
            if (i == 1002 && !booleanValue4) {
                u().setText(R.string.obfuscated_res_0x7f0f0fa2);
            } else {
                u().setText(R.string.obfuscated_res_0x7f0f048e);
            }
            z().setVisibility(8);
        } else {
            z().setVisibility(8);
            u().setVisibility(8);
        }
        boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
        if (!c.a.p0.w2.m.f.n1.a.i(uVar) && !booleanValue7 && booleanValue6) {
            SparseArray sparseArray5 = new SparseArray();
            sparseArray5.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
            sparseArray5.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
            sparseArray5.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
            sparseArray5.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
            sparseArray5.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
            sparseArray5.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
            sparseArray5.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
            D().setTag(sparseArray5);
            D().setVisibility(0);
            z().setVisibility(8);
            D().setText(R.string.obfuscated_res_0x7f0f0b17);
        } else {
            if (sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean) {
                ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue();
            }
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091e79) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e79) : null;
            if (z) {
                D().setVisibility(0);
                D().setTag(str2);
            } else {
                D().setVisibility(8);
            }
        }
        B().setVisibility(8);
        t().setVisibility(8);
        w().setVisibility(8);
        A().setVisibility(8);
        E().setVisibility(8);
        c.a.p0.w2.m.f.n1.a.l(this.t, postData, uVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(SparseArray<Object> sparseArray, int i, boolean z, boolean z2, c.a.p0.w2.i.u uVar) {
        boolean z3;
        boolean booleanValue;
        int i2;
        int i3;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{sparseArray, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), uVar}) == null) || sparseArray == null) {
            return;
        }
        PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69);
        SparseArray sparseArray2 = new SparseArray();
        sparseArray2.put(R.id.obfuscated_res_0x7f091e69, (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69));
        sparseArray2.put(R.id.obfuscated_res_0x7f091e82, Boolean.FALSE);
        A().setTag(sparseArray2);
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(R.id.obfuscated_res_0x7f091e69, (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69));
        t().setTag(sparseArray3);
        boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
        boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091e81) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e81)).booleanValue() : false;
        String str = sparseArray.get(R.id.obfuscated_res_0x7f091e79) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e79) : null;
        if (booleanValue2) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
            sparseArray4.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e76, sparseArray.get(R.id.obfuscated_res_0x7f091e76));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e77, sparseArray.get(R.id.obfuscated_res_0x7f091e77));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e78, sparseArray.get(R.id.obfuscated_res_0x7f091e78));
            sparseArray4.put(R.id.obfuscated_res_0x7f091e79, str);
            if (!c.a.p0.w2.m.f.n1.a.i(uVar) && booleanValue3) {
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                sparseArray4.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
            } else {
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
            }
            if (booleanValue4) {
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                if (booleanValue6) {
                    u().setVisibility(0);
                } else {
                    u().setVisibility(8);
                }
            } else {
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                u().setVisibility(8);
            }
            z().setTag(sparseArray4);
            u().setTag(sparseArray4);
            z().setText(R.string.obfuscated_res_0x7f0f02d3);
            z().setVisibility(0);
        } else if (booleanValue4) {
            SparseArray sparseArray5 = new SparseArray();
            sparseArray5.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
            sparseArray5.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
            sparseArray5.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
            sparseArray5.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue5));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
            sparseArray5.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
            z().setTag(sparseArray5);
            u().setTag(sparseArray5);
            z().setText(R.string.obfuscated_res_0x7f0f048e);
            u().setVisibility(0);
            if (i == 1002 && !booleanValue5) {
                u().setText(R.string.obfuscated_res_0x7f0f0fa2);
            } else {
                u().setText(R.string.obfuscated_res_0x7f0f048e);
            }
            z().setVisibility(8);
        } else {
            z().setVisibility(8);
            u().setVisibility(8);
        }
        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
        boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
        if (!c.a.p0.w2.m.f.n1.a.i(uVar) && !booleanValue8 && booleanValue7) {
            SparseArray sparseArray6 = new SparseArray();
            sparseArray6.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
            sparseArray6.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
            sparseArray6.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
            sparseArray6.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
            sparseArray6.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
            sparseArray6.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
            sparseArray6.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
            sparseArray6.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
            D().setTag(sparseArray6);
            D().setVisibility(0);
            z().setVisibility(8);
            D().setText(R.string.obfuscated_res_0x7f0f0b17);
        } else {
            if (sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean) {
                ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue();
            }
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091e79) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e79) : null;
            if (z) {
                D().setVisibility(0);
                D().setTag(str2);
            } else {
                D().setVisibility(8);
            }
        }
        boolean booleanValue9 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
        long longValue = sparseArray.get(R.id.obfuscated_res_0x7f091e68) instanceof Long ? ((Long) sparseArray.get(R.id.obfuscated_res_0x7f091e68)).longValue() : 0L;
        String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091e67) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e67) : "";
        int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e66) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e66)).intValue() : 0;
        if (booleanValue9) {
            B().setVisibility(0);
            B().setTag(R.id.obfuscated_res_0x7f091e68, Long.valueOf(longValue));
            B().setTag(R.id.obfuscated_res_0x7f091e67, str3);
            B().setTag(R.id.obfuscated_res_0x7f091e66, Integer.valueOf(intValue));
        } else {
            B().setVisibility(8);
        }
        if (sparseArray.get(R.id.obfuscated_res_0x7f091ea3) instanceof Boolean) {
            z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea3)).booleanValue();
            if (this.w.getPageActivity() instanceof NewSubPbActivity) {
                NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.w.getPageActivity();
                if (z3 && newSubPbActivity.getSubPbModel() != null && newSubPbActivity.getSubPbModel().l0() != null && newSubPbActivity.getSubPbModel().l0().l() != null && !newSubPbActivity.getSubPbModel().l0().l().isBjh()) {
                    z3 = true;
                }
            }
            booleanValue = !(sparseArray.get(R.id.obfuscated_res_0x7f091ea4) instanceof Boolean) ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea4)).booleanValue() : false;
            if (!z3) {
                i2 = 0;
                w().setVisibility(0);
                i3 = 8;
            } else {
                i2 = 0;
                i3 = 8;
                w().setVisibility(8);
            }
            if (!booleanValue) {
                E().setVisibility(i2);
            } else {
                E().setVisibility(i3);
            }
            if (z3 && !booleanValue) {
                t().setVisibility(i2);
            } else {
                t().setVisibility(i3);
            }
            v().setVisibility(i3);
            if (z2) {
                u().setVisibility(i3);
                z().setVisibility(i3);
                D().setVisibility(i3);
            }
            if (UbsABTestHelper.isPBPlanA()) {
                if (postData != null) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e85, postData);
                    C().setTag(sparseArray7);
                    C().setText(R.string.obfuscated_res_0x7f0f0088);
                    C().setVisibility(0);
                }
                if (postData != null) {
                    SparseArray sparseArray8 = new SparseArray();
                    sparseArray8.put(R.id.obfuscated_res_0x7f091e85, postData);
                    sparseArray8.put(R.id.obfuscated_res_0x7f091e82, Boolean.valueOf(!postData.l0));
                    F().setTag(sparseArray8);
                    F().setText(R.string.obfuscated_res_0x7f0f0089);
                    C().setVisibility(0);
                }
                if (postData.q() != null) {
                    boolean z4 = postData.q().hasAgree;
                    int r = postData.r();
                    if (z4 && r == 5) {
                        string = this.w.getString(R.string.obfuscated_res_0x7f0f0083);
                    } else {
                        string = this.w.getString(R.string.obfuscated_res_0x7f0f0085);
                    }
                    SparseArray sparseArray9 = new SparseArray();
                    sparseArray9.put(R.id.obfuscated_res_0x7f091e69, postData);
                    v().setTag(sparseArray9);
                    v().setVisibility(0);
                    v().setText(string);
                }
            }
            c.a.p0.w2.m.f.n1.a.l(this.t, postData, uVar);
        }
        z3 = false;
        if (!(sparseArray.get(R.id.obfuscated_res_0x7f091ea4) instanceof Boolean)) {
        }
        if (!z3) {
        }
        if (!booleanValue) {
        }
        if (z3) {
        }
        t().setVisibility(i3);
        v().setVisibility(i3);
        if (z2) {
        }
        if (UbsABTestHelper.isPBPlanA()) {
        }
        c.a.p0.w2.m.f.n1.a.l(this.t, postData, uVar);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a aVar = new a(this);
            if (UbsABTestHelper.isPBPlanA()) {
                j(null, new String[]{this.w.getString(R.string.obfuscated_res_0x7f0f0088), this.w.getString(R.string.obfuscated_res_0x7f0f0089), this.w.getString(R.string.obfuscated_res_0x7f0f0085), this.w.getString(R.string.obfuscated_res_0x7f0f0c40), this.w.getString(R.string.obfuscated_res_0x7f0f1067), this.w.getString(R.string.obfuscated_res_0x7f0f1068), this.w.getString(R.string.obfuscated_res_0x7f0f0435), this.w.getString(R.string.obfuscated_res_0x7f0f0a7f), this.w.getString(R.string.obfuscated_res_0x7f0f0fa2), this.w.getString(R.string.obfuscated_res_0x7f0f048e), this.w.getString(R.string.obfuscated_res_0x7f0f0b13), this.w.getString(R.string.obfuscated_res_0x7f0f0310)}, aVar);
                this.u = x(y(0));
                this.v = x(y(1));
                this.s = x(y(2));
                this.r = x(y(3));
                this.p = x(y(4));
                this.q = x(y(5));
                this.o = x(y(6));
                this.k = x(y(7));
                this.m = x(y(8));
                this.n = x(y(9));
                this.l = x(y(10));
                this.t = x(y(11));
                return;
            }
            j(null, new String[]{this.w.getString(R.string.obfuscated_res_0x7f0f0085), this.w.getString(R.string.obfuscated_res_0x7f0f0c40), this.w.getString(R.string.obfuscated_res_0x7f0f1067), this.w.getString(R.string.obfuscated_res_0x7f0f1068), this.w.getString(R.string.obfuscated_res_0x7f0f0435), this.w.getString(R.string.obfuscated_res_0x7f0f0a7f), this.w.getString(R.string.obfuscated_res_0x7f0f0fa2), this.w.getString(R.string.obfuscated_res_0x7f0f048e), this.w.getString(R.string.obfuscated_res_0x7f0f0b13), this.w.getString(R.string.obfuscated_res_0x7f0f0310)}, aVar);
            this.r = x(y(1));
            this.k = x(y(5));
            this.l = x(y(8));
            this.m = x(y(6));
            this.n = x(y(7));
            this.o = x(y(4));
            this.p = x(y(2));
            this.q = x(y(3));
            this.s = x(y(0));
            this.t = x(y(9));
        }
    }

    public TextView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.t : (TextView) invokeV.objValue;
    }

    public TextView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : (TextView) invokeV.objValue;
    }

    public TextView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public TextView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : (TextView) invokeV.objValue;
    }

    public TextView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.p : (TextView) invokeV.objValue;
    }

    public final TextView x(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) ? (TextView) view.findViewById(R.id.obfuscated_res_0x7f090fb2) : (TextView) invokeL.objValue;
    }

    public View y(int i) {
        InterceptResult invokeI;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            View view = this.f11066c;
            if (view != null && (view instanceof ViewGroup) && (findViewById = view.findViewById(R.id.obfuscated_res_0x7f0906e9)) != null && (findViewById instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) findViewById;
                int childCount = viewGroup.getChildCount();
                if (i >= 0 && i <= childCount - 1) {
                    return viewGroup.getChildAt(i);
                }
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public TextView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }
}
