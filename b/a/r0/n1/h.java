package b.a.r0.n1;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f22812a;

    /* renamed from: b  reason: collision with root package name */
    public long f22813b;

    /* renamed from: c  reason: collision with root package name */
    public String f22814c;

    /* renamed from: d  reason: collision with root package name */
    public int f22815d;

    /* renamed from: e  reason: collision with root package name */
    public int f22816e;

    /* renamed from: f  reason: collision with root package name */
    public int f22817f;

    public h() {
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
        this.f22813b = 0L;
        this.f22812a = new HashMap<>();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22816e : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22817f : invokeV.intValue;
    }

    public void c(List<String> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, list, i2, i3) == null) {
            synchronized (this.f22812a) {
                if (System.nanoTime() - this.f22813b > AbsMsgImageActivity.INV_TIME && list != null && i2 < list.size()) {
                    this.f22812a.put(list.get(i2), Boolean.TRUE);
                }
                this.f22813b = System.nanoTime();
                if (list != null && i3 < list.size() && this.f22812a.get(list.get(i3)) == null) {
                    this.f22812a.put(list.get(i3), Boolean.FALSE);
                }
            }
            if (this.f22812a.size() >= 100) {
                g();
            }
        }
    }

    public void d(Bundle bundle, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, intent) == null) {
            if (bundle != null) {
                this.f22814c = bundle.getString(ImageViewerConfig.PV_TYPE);
            } else if (intent != null) {
                this.f22814c = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                int intExtra = intent.getIntExtra("index", -1);
                this.f22815d = intExtra;
                this.f22816e = intExtra;
                this.f22817f = intExtra;
            }
        }
    }

    public void e(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) && i2 == 1 && System.nanoTime() - this.f22813b > AbsMsgImageActivity.INV_TIME) {
            this.f22812a.put(str, Boolean.TRUE);
        }
    }

    public void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putString(ImageViewerConfig.PV_TYPE, this.f22814c);
    }

    public void g() {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hashMap = this.f22812a) == null) {
            return;
        }
        synchronized (hashMap) {
            if (this.f22812a.size() <= 0) {
                return;
            }
            int i2 = 0;
            for (Map.Entry<String, Boolean> entry : this.f22812a.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    i2++;
                }
            }
            TbadkCoreApplication.getInst().sendImagePv(i2, this.f22812a.size(), this.f22814c, this.f22815d + 1, this.f22816e + 1);
            this.f22812a.clear();
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f22816e = i2;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f22817f = i2;
        }
    }

    public void j(int i2, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, str5}) == null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i3 = this.f22817f;
            if (i3 != this.f22816e) {
                while (true) {
                    int i4 = this.f22816e;
                    if (i3 > i4) {
                        break;
                    }
                    if (i3 == i4) {
                        sb.append(i3 + 1);
                        if (this.f22816e == i2 - 1) {
                            sb2.append(1);
                        } else {
                            sb2.append(0);
                        }
                    } else {
                        sb.append(i3 + 1);
                        sb.append("|");
                        sb2.append(0);
                        sb2.append("|");
                    }
                    i3++;
                }
            } else {
                sb.append(i3 + 1);
                if (this.f22816e == i2 - 1) {
                    sb2.append(1);
                } else {
                    sb2.append(0);
                }
            }
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a008");
            if (!k.isEmpty(str2)) {
                statisticItem.param("fid", str2);
            }
            if (!k.isEmpty(str3)) {
                statisticItem.param("tid", str3);
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().q);
            }
            statisticItem.param("pic_count", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR_MERGE, sb.toString());
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD_MERGE, sb2.toString());
            int i5 = this.f22816e;
            int i6 = (i5 - this.f22817f) + 1;
            if (i6 == 1) {
                if (i5 == i2 - 1) {
                    statisticItem.param("obj_id", str);
                } else {
                    statisticItem.param("obj_id", "");
                }
            }
            if (i6 > 1) {
                StringBuilder sb3 = new StringBuilder();
                for (int i7 = 0; i7 < i6 - 1; i7++) {
                    sb3.append("|");
                }
                if (this.f22816e == i2 - 1) {
                    sb3.append(str);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_ID_MERGE, str);
            }
            if (!StringUtils.isNull(str4)) {
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, str4);
            }
            if (!StringUtils.isNull(str5)) {
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, str5);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
