package c.a.t0.z2;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26863b;

    /* renamed from: c  reason: collision with root package name */
    public String f26864c;

    /* renamed from: d  reason: collision with root package name */
    public String f26865d;

    /* renamed from: e  reason: collision with root package name */
    public String f26866e;

    /* renamed from: f  reason: collision with root package name */
    public int f26867f;

    public r() {
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

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "Unknown";
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1679289728:
                    if (str.equals("Concern")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -1152667590:
                    if (str.equals("ad_feed")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -654725321:
                    if (str.equals("ad_video_landing")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -421681106:
                    if (str.equals("HomePage")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -181435716:
                    if (str.equals("HomeVideo")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 2546:
                    if (str.equals("PB")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 70919:
                    if (str.equals("Frs")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 175967569:
                    if (str.equals(FrsVideoTabPlayActivityConfig.KEY_FPS_MIDDLE_VIDEO_PAGE)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 671041499:
                    if (str.equals("ad_paster")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1974553171:
                    if (str.equals(PlayerConstant.PAGE_VIDEO_LANDING)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                case 2:
                    return "ad";
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                    return "tbc";
                default:
                    return "Unknown";
            }
        }
        return (String) invokeL.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "Unknown";
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
                    return "HomePage";
                case 1:
                    return "Concern";
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return "Frs";
                case 7:
                    return "PB";
                case '\b':
                case '\t':
                case '\n':
                    return "HomeVideo";
                case 11:
                    return FrsVideoTabPlayActivityConfig.KEY_FPS_MIDDLE_VIDEO_PAGE;
                case '\f':
                    return PlayerConstant.PAGE_VIDEO_LANDING;
                default:
                    return "Unknown";
            }
        }
        return (String) invokeL.objValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 1;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str.equals("2")) {
                    c2 = 1;
                }
            } else if (str.equals("1")) {
                c2 = 0;
            }
            return (c2 == 0 || c2 != 1) ? 1 : 0;
        }
        return invokeL.intValue;
    }
}
