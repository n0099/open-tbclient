package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ev4;
import com.repackage.mo4;
import com.repackage.ni;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TbLinkSpanGroup extends ev4<TbLinkSpanGroup> {
    public static /* synthetic */ Interceptable $ic;
    public static final String r;
    public transient /* synthetic */ FieldHolder $fh;
    public mo4 i;
    public LINK_TYPE j;
    public int k;
    public CharSequence l;
    public CharSequence m;
    public String n;
    public String o;
    public String p;
    public int q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class LINK_TYPE {
        public static final /* synthetic */ LINK_TYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LINK_TYPE DEAULT;
        public static final LINK_TYPE INTERNAL_LINK;
        public static final LINK_TYPE PARSABLE_EXTERNAL_LINK;
        public static final LINK_TYPE PARSED_EXTERNAL_LINK;
        public static final LINK_TYPE UNPAESABLE_EXTERNAL_LINK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1600513322, "Lcom/baidu/tbadk/core/view/spanGroup/TbLinkSpanGroup$LINK_TYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1600513322, "Lcom/baidu/tbadk/core/view/spanGroup/TbLinkSpanGroup$LINK_TYPE;");
                    return;
                }
            }
            INTERNAL_LINK = new LINK_TYPE("INTERNAL_LINK", 0);
            PARSED_EXTERNAL_LINK = new LINK_TYPE("PARSED_EXTERNAL_LINK", 1);
            PARSABLE_EXTERNAL_LINK = new LINK_TYPE("PARSABLE_EXTERNAL_LINK", 2);
            UNPAESABLE_EXTERNAL_LINK = new LINK_TYPE("UNPAESABLE_EXTERNAL_LINK", 3);
            LINK_TYPE link_type = new LINK_TYPE("DEAULT", 4);
            DEAULT = link_type;
            $VALUES = new LINK_TYPE[]{INTERNAL_LINK, PARSED_EXTERNAL_LINK, PARSABLE_EXTERNAL_LINK, UNPAESABLE_EXTERNAL_LINK, link_type};
        }

        public LINK_TYPE(String str, int i) {
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

        public static LINK_TYPE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LINK_TYPE) Enum.valueOf(LINK_TYPE.class, str) : (LINK_TYPE) invokeL.objValue;
        }

        public static LINK_TYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LINK_TYPE[]) $VALUES.clone() : (LINK_TYPE[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-803000571, "Lcom/baidu/tbadk/core/view/spanGroup/TbLinkSpanGroup;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-803000571, "Lcom/baidu/tbadk/core/view/spanGroup/TbLinkSpanGroup;");
                return;
            }
        }
        r = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f154f);
    }

    public TbLinkSpanGroup() {
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
        this.k = 0;
        this.j = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup x(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, tbLinkSpanGroup, editable)) == null) {
            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
            tbLinkSpanGroup2.b(tbLinkSpanGroup);
            tbLinkSpanGroup2.n(editable);
            return tbLinkSpanGroup2;
        }
        return (TbLinkSpanGroup) invokeLL.objValue;
    }

    public void A(LINK_TYPE link_type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, link_type) == null) {
            this.j = link_type;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.n = str;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.l = str;
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.k == 1) {
            return;
        }
        this.k = 1;
        this.p = r;
        String str = "[p]" + r + ((Object) this.m);
        this.q = str.length();
        i(str);
        if (f() > this.q || f() + 3 > this.q || c() > this.q) {
            return;
        }
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f08096c, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.c(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        l(eMRichTextAnyIconSpan, f(), f() + 3, 33);
        l(new SpanGroupForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), f() + 3, c(), 33);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.k == 2 || ni.isEmpty(this.o)) {
            return;
        }
        this.k = 2;
        this.p = StringHelper.cutStringWithEllipsisStrict(this.o, 40);
        String str = "[p]" + this.p + ((Object) this.m);
        this.q = str.length();
        i(str);
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f08096c, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.c(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        l(eMRichTextAnyIconSpan, f(), f() + 3, 33);
        l(new SpanGroupForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), f() + 3, c(), 33);
    }

    @Override // com.repackage.ev4
    public void a(Editable editable, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048581, this, editable, i, i2, i3) == null) {
            super.a(editable, i, i2, i3);
            if (this.j == LINK_TYPE.PARSED_EXTERNAL_LINK) {
                this.m = " ";
                return;
            }
            int i4 = i2 - 1;
            this.l = editable.subSequence(i, i4);
            this.m = editable.subSequence(i4, i2);
        }
    }

    @Override // com.repackage.ev4
    public void p(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, editable) == null) {
            mo4 mo4Var = this.i;
            if (mo4Var != null && mo4Var.b == 2) {
                if (mo4Var.h != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("#(commodity,commo_");
                    sb.append(this.i.h);
                    sb.append("_commo)");
                    i(sb);
                    return;
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.l);
            sb2.append(this.m);
            i(sb2);
        }
    }

    @Override // com.repackage.ev4
    public void q(Editable editable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, editable, i) == null) {
            if (this.i == null) {
                String str = ni.isEmpty(this.n) ? "0" : this.n;
                String str2 = (this.j == LINK_TYPE.INTERNAL_LINK && ni.isEmpty(this.o)) ? "" : this.p;
                StringBuilder sb = new StringBuilder();
                sb.append("#(url,");
                sb.append(str);
                sb.append(",");
                sb.append(ni.getUrlEncode(this.l.toString()));
                sb.append(",");
                sb.append(ni.getUrlEncode(str2));
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append(this.m);
                i(sb);
                return;
            }
            LINK_TYPE link_type = this.j;
            if (link_type != LINK_TYPE.INTERNAL_LINK && link_type != LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
                if (link_type == LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("goods_id", this.i.m);
                        jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i);
                        jSONObject2.put("title", this.i.d);
                        jSONObject2.put("url", this.i.k);
                        StringBuilder sb2 = new StringBuilder();
                        jSONObject.put("goods", jSONObject2);
                        sb2.append("#(goods,");
                        sb2.append(ni.getUrlEncode(jSONObject.toString()));
                        sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                        sb2.append(this.m);
                        i(sb2);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            String str3 = this.p;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("#(url,0,");
            sb3.append(ni.getUrlEncode(this.l.toString()));
            sb3.append(",");
            sb3.append(ni.getUrlEncode(str3));
            sb3.append(",");
            sb3.append(ni.getUrlEncode(this.i.l));
            sb3.append(",");
            sb3.append(this.i.e);
            sb3.append(",");
            sb3.append(ni.getUrlEncode(this.i.f));
            sb3.append(",");
            sb3.append(i);
            sb3.append(",");
            sb3.append(this.i.o);
            sb3.append(SmallTailInfo.EMOTION_SUFFIX);
            sb3.append(this.m);
            i(sb3);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(true);
            if (this.j == LINK_TYPE.PARSED_EXTERNAL_LINK) {
                E();
            } else {
                D();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ev4
    /* renamed from: s */
    public void b(TbLinkSpanGroup tbLinkSpanGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbLinkSpanGroup) == null) {
            super.b(tbLinkSpanGroup);
            this.j = tbLinkSpanGroup.j;
            this.k = tbLinkSpanGroup.k;
            this.l = tbLinkSpanGroup.l;
            this.m = tbLinkSpanGroup.m;
            this.n = tbLinkSpanGroup.n;
            this.o = tbLinkSpanGroup.o;
            this.p = tbLinkSpanGroup.p;
            this.i = tbLinkSpanGroup.i;
        }
    }

    public mo4 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.i : (mo4) invokeV.objValue;
    }

    public LINK_TYPE u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : (LINK_TYPE) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : invokeV.intValue;
    }

    public void y(mo4 mo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mo4Var) == null) {
            this.i = mo4Var;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.o = str;
        }
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {link_type};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.j = link_type;
    }
}
