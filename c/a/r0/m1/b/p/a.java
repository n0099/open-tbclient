package c.a.r0.m1.b.p;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
import tbclient.AgreeList;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class a extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A;
    public static final BdUniqueId B;
    public static final BdUniqueId x;
    public static final BdUniqueId y;
    public static final BdUniqueId z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f22208e;

    /* renamed from: f  reason: collision with root package name */
    public MetaData f22209f;

    /* renamed from: g  reason: collision with root package name */
    public String f22210g;

    /* renamed from: h  reason: collision with root package name */
    public long f22211h;

    /* renamed from: i  reason: collision with root package name */
    public String f22212i;

    /* renamed from: j  reason: collision with root package name */
    public String f22213j;
    public OriginalThreadInfo k;
    public String l;
    public MetaData m;
    public int n;
    public String o;
    public String p;
    public long q;
    public boolean r;
    public String s;
    public boolean t;
    public boolean u;
    public BaijiahaoData v;
    public String w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1590273498, "Lc/a/r0/m1/b/p/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1590273498, "Lc/a/r0/m1/b/p/a;");
                return;
            }
        }
        x = BdUniqueId.gen();
        y = BdUniqueId.gen();
        z = BdUniqueId.gen();
        A = BdUniqueId.gen();
        B = BdUniqueId.gen();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22209f = new MetaData();
        this.u = false;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22211h : invokeV.longValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public void F(FeedData feedData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, feedData) == null) || feedData == null) {
            return;
        }
        this.f22209f = feedData.getReplyer();
        this.f22211h = feedData.getTime();
        this.p = feedData.getPost_id();
        if (!feedData.isHideForumName()) {
            this.l = feedData.getFname();
        }
        this.o = feedData.getThread_id();
        this.n = feedData.getThread_Type();
        this.f22212i = feedData.getContent();
        this.r = feedData.getIsFloor();
        this.f22210g = feedData.getPostFrom();
        this.s = feedData.getQuote_pid();
        this.t = feedData.isNew();
        this.m = feedData.getThreadAuthor();
        this.u = feedData.isBjh();
        this.v = feedData.getBaijiahaoData();
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        this.k = originalThreadInfo;
        originalThreadInfo.f47437f = this.o;
        originalThreadInfo.k = this.n;
        originalThreadInfo.f47434c = feedData.getThreadImgUrl();
        OriginalThreadInfo originalThreadInfo2 = this.k;
        originalThreadInfo2.o = this.u;
        originalThreadInfo2.p = this.v;
        this.w = "c12928";
        if (feedData.getType() == 1) {
            this.k.n = feedData.getQuote_pid();
            if (feedData.getQuote_user() == null) {
                str = "";
            } else if (StringHelper.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                str = TbadkCoreApplication.getInst().getString(R.string.me);
            } else {
                str = feedData.getQuote_user().getName_show();
            }
            this.k.f47438g = TbadkCoreApplication.getInst().getString(R.string.reply_me_original, new Object[]{str, feedData.getQuote_content()});
            if (TextUtils.isGraphic(this.k.f47438g)) {
                OriginalThreadInfo originalThreadInfo3 = this.k;
                originalThreadInfo3.f47438g = originalThreadInfo3.f47438g.replace(StringUtils.LF, " ");
            }
            if (feedData.getIsFloor()) {
                this.f22208e = z;
            } else {
                this.f22208e = A;
            }
        } else {
            this.k.n = "0";
            if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                this.k.f47438g = TbadkCoreApplication.getInst().getString(R.string.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().f47433b});
            } else {
                this.k.f47438g = feedData.getTitle();
            }
            this.f22208e = B;
        }
        this.k.q();
    }

    public void G(AgreeList agreeList) {
        User user;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, agreeList) == null) || agreeList == null) {
            return;
        }
        this.q = agreeList.id.longValue();
        MetaData metaData = new MetaData();
        this.f22209f = metaData;
        metaData.parserProtobuf(agreeList.agreeer);
        this.f22211h = agreeList.time.intValue() * 1000;
        Post post = agreeList.post_info;
        if (post != null) {
            this.p = String.valueOf(post.id);
            if (!ListUtils.isEmpty(agreeList.post_info.content) && ListUtils.getItem(agreeList.post_info.content, 0) != null && (user = agreeList.post_info.author) != null) {
                String str = user.name_show;
                if (k.isEmpty(str)) {
                    str = agreeList.post_info.author.name;
                }
                this.f22213j = str + "：" + agreeList.post_info.content.get(0).text;
            }
            this.s = agreeList.post_info.quote_id;
        }
        d2 d2Var = new d2();
        d2Var.Y2(agreeList.thread_info);
        this.k = OriginalThreadInfo.k(d2Var);
        this.m = d2Var.J();
        this.l = d2Var.Z();
        this.o = d2Var.f0();
        this.n = d2Var.i0;
        this.u = d2Var.D2();
        this.v = d2Var.L();
        this.w = "c12927";
        if (agreeList.type.intValue() == 3) {
            this.f22208e = x;
            this.f22212i = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_thread);
            if (this.u) {
                this.f22212i = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_dynamic);
                return;
            }
            return;
        }
        this.f22208e = y;
        this.f22212i = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_post);
    }

    public void H(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) {
            this.t = z2;
        }
    }

    public BaijiahaoData g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.v : (BaijiahaoData) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22212i : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f22208e : (BdUniqueId) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.q : invokeV.longValue;
    }

    public OriginalThreadInfo o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (OriginalThreadInfo) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f22210g : (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public MetaData w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f22209f : (MetaData) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f22213j : (String) invokeV.objValue;
    }

    public MetaData z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.m : (MetaData) invokeV.objValue;
    }
}
