package c.a.o0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13865a;

    /* renamed from: b  reason: collision with root package name */
    public String f13866b;

    /* renamed from: c  reason: collision with root package name */
    public y f13867c;

    public c0() {
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
        this.f13865a = "";
        this.f13866b = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13865a : (String) invokeV.objValue;
    }

    public void b(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumHeadlineImgInfo) == null) || forumHeadlineImgInfo == null) {
            return;
        }
        forumHeadlineImgInfo.thread_id.longValue();
        forumHeadlineImgInfo.thread_user_id.longValue();
        String str = forumHeadlineImgInfo.thread_user_name;
        forumHeadlineImgInfo.img_user_id.longValue();
        String str2 = forumHeadlineImgInfo.img_user_name;
        this.f13865a = forumHeadlineImgInfo.img_url;
        this.f13866b = forumHeadlineImgInfo.headline_url;
        this.f13867c = new y();
        ArrayList<b0> arrayList = new ArrayList<>();
        String str3 = this.f13865a;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.f13866b;
        b0 b0Var = new b0(str3, str4 != null ? str4 : "", null);
        b0Var.n(true);
        arrayList.add(b0Var);
        this.f13867c.g(arrayList);
    }
}
