package c.a.r0.p2;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f23822a;

    /* renamed from: b  reason: collision with root package name */
    public String f23823b;

    /* renamed from: c  reason: collision with root package name */
    public String f23824c;

    /* renamed from: d  reason: collision with root package name */
    public String f23825d;

    /* renamed from: e  reason: collision with root package name */
    public String f23826e;

    /* renamed from: f  reason: collision with root package name */
    public String f23827f;

    /* renamed from: g  reason: collision with root package name */
    public String f23828g;

    /* renamed from: h  reason: collision with root package name */
    public String f23829h;

    /* renamed from: i  reason: collision with root package name */
    public String f23830i;

    /* renamed from: j  reason: collision with root package name */
    public int f23831j;
    public String k;
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

    /* loaded from: classes3.dex */
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
                        } else if (str.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
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

    public o() {
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
                if (!StringUtils.isNull(this.f23822a)) {
                    statisticItem.param("obj_locate", this.f23822a);
                    statisticItem.param("page_type", a.a(this.f23822a));
                }
                if (!StringUtils.isNull(this.f23824c)) {
                    statisticItem.param("tid", this.f23824c);
                }
                if (!StringUtils.isNull(this.f23825d)) {
                    statisticItem.param("fid", this.f23825d);
                }
                if (!StringUtils.isNull(this.f23826e)) {
                    statisticItem.param("uid", this.f23826e);
                }
                if (!StringUtils.isNull(this.f23827f)) {
                    statisticItem.param("obj_source", this.f23827f);
                } else {
                    statisticItem.param("obj_source", 0);
                }
                if (!StringUtils.isNull(this.f23828g)) {
                    statisticItem.param("obj_param1", this.f23828g);
                } else {
                    statisticItem.param("obj_param1", 0);
                }
                if (!StringUtils.isNull(this.f23829h)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.f23829h);
                }
                if (!StringUtils.isNull(this.f23830i)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f23830i);
                }
                int i2 = this.f23831j;
                if (i2 > 0) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, i2);
                }
                if (!StringUtils.isNull(this.k)) {
                    statisticItem.param("obj_id", this.k);
                }
                if (!StringUtils.isNull(this.l)) {
                    statisticItem.param("ab_tag", this.l);
                } else {
                    statisticItem.param("ab_tag", 0);
                }
                if (!StringUtils.isNull(this.n)) {
                    statisticItem.param("topic_type", this.n);
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

    public o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            o oVar = new o();
            oVar.f23822a = this.f23822a;
            oVar.f23823b = this.f23823b;
            oVar.f23824c = this.f23824c;
            oVar.f23825d = this.f23825d;
            oVar.f23826e = this.f23826e;
            oVar.f23827f = this.f23827f;
            oVar.f23828g = this.f23828g;
            oVar.f23829h = this.f23829h;
            oVar.f23830i = this.f23830i;
            oVar.k = this.k;
            oVar.l = this.l;
            oVar.m = this.m;
            oVar.n = this.n;
            oVar.q = this.q;
            oVar.r = this.r;
            oVar.s = this.s;
            oVar.t = this.t;
            oVar.u = this.u;
            oVar.v = this.v;
            return oVar;
        }
        return (o) invokeV.objValue;
    }
}
