package c.a.p0.a4.k0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<h> f12240b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<k> f12241c;

    public i(TPointPost tPointPost) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tPointPost};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tPointPost != null) {
            try {
                String str = tPointPost.position;
                tPointPost.template_id.longValue();
                this.a = tPointPost.is_tuiguang.intValue() != 0;
                tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.f12240b = new ArrayList<>();
                    for (int i3 = 0; i3 != list.size(); i3++) {
                        this.f12240b.add(new h(list.get(i3)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.f12241c = new ArrayList<>();
                    for (int i4 = 0; i4 != list2.size(); i4++) {
                        this.f12241c.add(new k(list2.get(i4)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    new j(tPointPost.detail_info);
                }
                String str2 = tPointPost.monitor_id;
                tPointPost.hidden_day.intValue();
                VideoInfo videoInfo = tPointPost.t_video;
                String str3 = tPointPost.tag_name;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (k) ListUtils.getItem(this.f12241c, 0) : (k) invokeV.objValue;
    }
}
