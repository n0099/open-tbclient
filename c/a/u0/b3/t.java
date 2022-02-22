package c.a.u0.b3;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f15609b;

    /* renamed from: c  reason: collision with root package name */
    public String f15610c;

    /* renamed from: d  reason: collision with root package name */
    public String f15611d;

    /* renamed from: e  reason: collision with root package name */
    public String f15612e;

    /* renamed from: f  reason: collision with root package name */
    public String f15613f;

    /* renamed from: g  reason: collision with root package name */
    public String f15614g;

    /* renamed from: h  reason: collision with root package name */
    public String f15615h;

    /* renamed from: i  reason: collision with root package name */
    public String f15616i;

    /* renamed from: j  reason: collision with root package name */
    public int f15617j;
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
    public String w;
    public int x;
    public int y;
    public String z;

    /* loaded from: classes7.dex */
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
                if (hashCode != 1567) {
                    if (hashCode != 1568) {
                        if (hashCode != 1570) {
                            if (hashCode != 1576) {
                                if (hashCode != 1599) {
                                    switch (hashCode) {
                                        case 49:
                                            if (str.equals("1")) {
                                                c2 = 0;
                                                break;
                                            }
                                            break;
                                        case 50:
                                            if (str.equals("2")) {
                                                c2 = 2;
                                                break;
                                            }
                                            break;
                                        case 51:
                                            if (str.equals("3")) {
                                                c2 = 4;
                                                break;
                                            }
                                            break;
                                        case 52:
                                            if (str.equals("4")) {
                                                c2 = 3;
                                                break;
                                            }
                                            break;
                                        default:
                                            switch (hashCode) {
                                                case 54:
                                                    if (str.equals("6")) {
                                                        c2 = 7;
                                                        break;
                                                    }
                                                    break;
                                                case 55:
                                                    if (str.equals("7")) {
                                                        c2 = 1;
                                                        break;
                                                    }
                                                    break;
                                                case 56:
                                                    if (str.equals("8")) {
                                                        c2 = '\b';
                                                        break;
                                                    }
                                                    break;
                                                case 57:
                                                    if (str.equals("9")) {
                                                        c2 = '\t';
                                                        break;
                                                    }
                                                    break;
                                            }
                                    }
                                } else if (str.equals("21")) {
                                    c2 = '\f';
                                }
                            } else if (str.equals("19")) {
                                c2 = '\n';
                            }
                        } else if (str.equals("13")) {
                            c2 = 11;
                        }
                    } else if (str.equals("11")) {
                        c2 = 6;
                    }
                } else if (str.equals("10")) {
                    c2 = 5;
                }
                switch (c2) {
                    case 0:
                    case 1:
                        return "a002";
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        return "a006";
                    case 7:
                        return "a005";
                    case '\b':
                    case '\t':
                    case '\n':
                        return "a020";
                    case 11:
                        return "a023";
                    case '\f':
                        return "a088";
                    default:
                        return "";
                }
            }
            return (String) invokeL.objValue;
        }
    }

    public t() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = "index";
    }

    public StatisticItem a(StatisticItem statisticItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, statisticItem)) == null) {
            if (statisticItem != null) {
                if (!StringUtils.isNull(this.a)) {
                    statisticItem.param("obj_locate", this.a);
                    statisticItem.param("page_type", a.a(this.a));
                    if (this.a.equals("21")) {
                        statisticItem.param(TiebaStatic.Params.BHV_ID, TbSingleton.getInstance().getCurrentClickTime());
                    }
                    if (this.a.equals("13") && !StringUtils.isNull(this.f15616i) && this.z.equals(this.f15616i)) {
                        statisticItem.param(TiebaStatic.Params.BHV_ID, TbSingleton.getInstance().getCurrentClickTime());
                    }
                }
                if (!StringUtils.isNull(this.f15610c)) {
                    statisticItem.param("tid", this.f15610c);
                }
                if (!StringUtils.isNull(this.f15611d)) {
                    statisticItem.param("fid", this.f15611d);
                }
                if (!StringUtils.isNull(this.f15612e)) {
                    statisticItem.param("uid", this.f15612e);
                }
                if (!StringUtils.isNull(this.f15613f)) {
                    statisticItem.param("obj_source", this.f15613f);
                } else {
                    statisticItem.param("obj_source", 0);
                }
                if (!StringUtils.isNull(this.f15614g)) {
                    statisticItem.param("obj_param1", this.f15614g);
                } else {
                    statisticItem.param("obj_param1", 0);
                }
                if (!StringUtils.isNull(this.f15615h)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.f15615h);
                }
                if (!StringUtils.isNull(this.f15616i)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f15616i);
                }
                int i2 = this.f15617j;
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
                int i3 = this.x;
                if (i3 > 0) {
                    statisticItem.param("request_num", i3);
                }
                int i4 = this.y;
                if (i4 > 0) {
                    statisticItem.param("video_num", i4);
                }
                statisticItem.param("obj_extra", StringUtils.isNull(this.w) ? "" : this.w);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, StringUtils.isNull(this.t) ? "" : this.t);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, StringUtils.isNull(this.u) ? "" : this.u);
                statisticItem.param("nid", StringUtils.isNull(this.v) ? "" : this.v);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public t b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            t tVar = new t();
            tVar.a = this.a;
            tVar.f15609b = this.f15609b;
            tVar.f15610c = this.f15610c;
            tVar.f15611d = this.f15611d;
            tVar.f15612e = this.f15612e;
            tVar.f15613f = this.f15613f;
            tVar.f15614g = this.f15614g;
            tVar.f15615h = this.f15615h;
            tVar.f15616i = this.f15616i;
            tVar.k = this.k;
            tVar.l = this.l;
            tVar.m = this.m;
            tVar.n = this.n;
            tVar.q = this.q;
            tVar.r = this.r;
            tVar.s = this.s;
            tVar.t = this.t;
            tVar.u = this.u;
            tVar.v = this.v;
            tVar.x = this.x;
            tVar.y = this.y;
            return tVar;
        }
        return (t) invokeV.objValue;
    }
}
