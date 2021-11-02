package b.a.r0.q2;

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
/* loaded from: classes5.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f22882a;

    /* renamed from: b  reason: collision with root package name */
    public String f22883b;

    /* renamed from: c  reason: collision with root package name */
    public String f22884c;

    /* renamed from: d  reason: collision with root package name */
    public String f22885d;

    /* renamed from: e  reason: collision with root package name */
    public String f22886e;

    /* renamed from: f  reason: collision with root package name */
    public String f22887f;

    /* renamed from: g  reason: collision with root package name */
    public String f22888g;

    /* renamed from: h  reason: collision with root package name */
    public String f22889h;

    /* renamed from: i  reason: collision with root package name */
    public String f22890i;
    public int j;
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

    /* loaded from: classes5.dex */
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
                if (!StringUtils.isNull(this.f22882a)) {
                    statisticItem.param("obj_locate", this.f22882a);
                    statisticItem.param("page_type", a.a(this.f22882a));
                }
                if (!StringUtils.isNull(this.f22884c)) {
                    statisticItem.param("tid", this.f22884c);
                }
                if (!StringUtils.isNull(this.f22885d)) {
                    statisticItem.param("fid", this.f22885d);
                }
                if (!StringUtils.isNull(this.f22886e)) {
                    statisticItem.param("uid", this.f22886e);
                }
                if (!StringUtils.isNull(this.f22887f)) {
                    statisticItem.param("obj_source", this.f22887f);
                } else {
                    statisticItem.param("obj_source", 0);
                }
                if (!StringUtils.isNull(this.f22888g)) {
                    statisticItem.param("obj_param1", this.f22888g);
                } else {
                    statisticItem.param("obj_param1", 0);
                }
                if (!StringUtils.isNull(this.f22889h)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.f22889h);
                }
                if (!StringUtils.isNull(this.f22890i)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f22890i);
                }
                int i2 = this.j;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            p pVar = new p();
            pVar.f22882a = this.f22882a;
            pVar.f22883b = this.f22883b;
            pVar.f22884c = this.f22884c;
            pVar.f22885d = this.f22885d;
            pVar.f22886e = this.f22886e;
            pVar.f22887f = this.f22887f;
            pVar.f22888g = this.f22888g;
            pVar.f22889h = this.f22889h;
            pVar.f22890i = this.f22890i;
            pVar.k = this.k;
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
