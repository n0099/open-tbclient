package c.a.s0.z2;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26405b;

    /* renamed from: c  reason: collision with root package name */
    public String f26406c;

    /* renamed from: d  reason: collision with root package name */
    public String f26407d;

    /* renamed from: e  reason: collision with root package name */
    public String f26408e;

    /* renamed from: f  reason: collision with root package name */
    public String f26409f;

    /* renamed from: g  reason: collision with root package name */
    public String f26410g;

    /* renamed from: h  reason: collision with root package name */
    public String f26411h;

    /* renamed from: i  reason: collision with root package name */
    public String f26412i;

    /* renamed from: j  reason: collision with root package name */
    public int f26413j;

    /* renamed from: k  reason: collision with root package name */
    public String f26414k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 54) {
                    if (hashCode != 1570) {
                        if (hashCode != 1576) {
                            if (hashCode != 1599) {
                                if (hashCode != 56) {
                                    if (hashCode != 57) {
                                        if (hashCode != 1567) {
                                            if (hashCode != 1568) {
                                                switch (hashCode) {
                                                    case 49:
                                                        if (str.equals("1")) {
                                                            c2 = 0;
                                                            break;
                                                        }
                                                        break;
                                                    case 50:
                                                        if (str.equals("2")) {
                                                            c2 = 1;
                                                            break;
                                                        }
                                                        break;
                                                    case 51:
                                                        if (str.equals("3")) {
                                                            c2 = 3;
                                                            break;
                                                        }
                                                        break;
                                                    case 52:
                                                        if (str.equals("4")) {
                                                            c2 = 2;
                                                            break;
                                                        }
                                                        break;
                                                }
                                            } else if (str.equals("11")) {
                                                c2 = 5;
                                            }
                                        } else if (str.equals("10")) {
                                            c2 = 4;
                                        }
                                    } else if (str.equals("9")) {
                                        c2 = '\b';
                                    }
                                } else if (str.equals("8")) {
                                    c2 = 7;
                                }
                            } else if (str.equals("21")) {
                                c2 = 11;
                            }
                        } else if (str.equals("19")) {
                            c2 = '\t';
                        }
                    } else if (str.equals("13")) {
                        c2 = '\n';
                    }
                } else if (str.equals("6")) {
                    c2 = 6;
                }
                switch (c2) {
                    case 0:
                        return "a002";
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return "a006";
                    case 6:
                        return "a005";
                    case 7:
                    case '\b':
                    case '\t':
                        return "a020";
                    case '\n':
                        return "a023";
                    case 11:
                        return "a088";
                    default:
                        return "";
                }
            }
            return (String) invokeL.objValue;
        }
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public StatisticItem a(StatisticItem statisticItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, statisticItem)) == null) {
            if (statisticItem != null) {
                if (!StringUtils.isNull(this.a)) {
                    statisticItem.param("obj_locate", this.a);
                    statisticItem.param("page_type", a.a(this.a));
                }
                if (!StringUtils.isNull(this.f26406c)) {
                    statisticItem.param("tid", this.f26406c);
                }
                if (!StringUtils.isNull(this.f26407d)) {
                    statisticItem.param("fid", this.f26407d);
                }
                if (!StringUtils.isNull(this.f26408e)) {
                    statisticItem.param("uid", this.f26408e);
                }
                if (!StringUtils.isNull(this.f26409f)) {
                    statisticItem.param("obj_source", this.f26409f);
                } else {
                    statisticItem.param("obj_source", 0);
                }
                if (!StringUtils.isNull(this.f26410g)) {
                    statisticItem.param("obj_param1", this.f26410g);
                } else {
                    statisticItem.param("obj_param1", 0);
                }
                if (!StringUtils.isNull(this.f26411h)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.f26411h);
                }
                if (!StringUtils.isNull(this.f26412i)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f26412i);
                }
                int i2 = this.f26413j;
                if (i2 > 0) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, i2);
                }
                if (!StringUtils.isNull(this.f26414k)) {
                    statisticItem.param("obj_id", this.f26414k);
                }
                if (!StringUtils.isNull(this.l)) {
                    statisticItem.param("ab_tag", this.l);
                } else {
                    statisticItem.param("ab_tag", 0);
                }
                if (!StringUtils.isNull(this.n)) {
                    statisticItem.param(TiebaStatic.Params.TOPIC_TYPE, this.n);
                }
                if (!StringUtils.isNull(this.o)) {
                    statisticItem.param("extra", this.o);
                } else {
                    statisticItem.param("extra", 0);
                }
                if (!StringUtils.isNull(this.p)) {
                    statisticItem.param(TiebaStatic.Params.IS_VERTICAL, this.p);
                }
                if (!StringUtils.isNull(this.q)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.q);
                }
                if (!StringUtils.isNull(this.r)) {
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.r);
                }
                if (!StringUtils.isNull(this.s)) {
                    statisticItem.param("group_id", this.s);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, StringUtils.isNull(this.t) ? "" : this.t);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, StringUtils.isNull(this.u) ? "" : this.u);
                statisticItem.param("nid", StringUtils.isNull(this.v) ? "" : this.v);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            p pVar = new p();
            pVar.a = this.a;
            pVar.f26405b = this.f26405b;
            pVar.f26406c = this.f26406c;
            pVar.f26407d = this.f26407d;
            pVar.f26408e = this.f26408e;
            pVar.f26409f = this.f26409f;
            pVar.f26410g = this.f26410g;
            pVar.f26411h = this.f26411h;
            pVar.f26412i = this.f26412i;
            pVar.f26414k = this.f26414k;
            pVar.l = this.l;
            pVar.m = this.m;
            pVar.n = this.n;
            pVar.q = this.q;
            pVar.r = this.r;
            pVar.s = this.s;
            pVar.t = this.t;
            pVar.u = this.u;
            pVar.v = this.v;
            return pVar;
        }
        return (p) invokeV.objValue;
    }
}
