package c.a.p0.v1.b.p;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
import tbclient.AgreeList;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes2.dex */
public class a extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId t;
    public static final BdUniqueId u;
    public static final BdUniqueId v;
    public static final BdUniqueId w;
    public static final BdUniqueId x;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public MetaData f19167b;

    /* renamed from: c  reason: collision with root package name */
    public String f19168c;

    /* renamed from: d  reason: collision with root package name */
    public long f19169d;

    /* renamed from: e  reason: collision with root package name */
    public String f19170e;

    /* renamed from: f  reason: collision with root package name */
    public String f19171f;

    /* renamed from: g  reason: collision with root package name */
    public OriginalThreadInfo f19172g;

    /* renamed from: h  reason: collision with root package name */
    public String f19173h;
    public MetaData i;
    public int j;
    public String k;
    public String l;
    public long m;
    public boolean n;
    public String o;
    public boolean p;
    public boolean q;
    public BaijiahaoData r;
    public String s;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-935659919, "Lc/a/p0/v1/b/p/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-935659919, "Lc/a/p0/v1/b/p/a;");
                return;
            }
        }
        t = BdUniqueId.gen();
        u = BdUniqueId.gen();
        v = BdUniqueId.gen();
        w = BdUniqueId.gen();
        x = BdUniqueId.gen();
    }

    public a() {
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
        this.f19167b = new MetaData();
        this.q = false;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void C(FeedData feedData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, feedData) == null) || feedData == null) {
            return;
        }
        this.f19167b = feedData.getReplyer();
        this.f19169d = feedData.getTime();
        this.l = feedData.getPost_id();
        if (!feedData.isHideForumName()) {
            this.f19173h = feedData.getFname();
        }
        this.k = feedData.getThread_id();
        this.j = feedData.getThread_Type();
        this.f19170e = feedData.getContent();
        this.n = feedData.getIsFloor();
        this.f19168c = feedData.getPostFrom();
        this.o = feedData.getQuote_pid();
        this.p = feedData.isNew();
        this.i = feedData.getThreadAuthor();
        this.q = feedData.isBjh();
        this.r = feedData.getBaijiahaoData();
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        this.f19172g = originalThreadInfo;
        originalThreadInfo.f29826f = this.k;
        originalThreadInfo.k = this.j;
        originalThreadInfo.f29823c = feedData.getThreadImgUrl();
        OriginalThreadInfo originalThreadInfo2 = this.f19172g;
        originalThreadInfo2.o = this.q;
        originalThreadInfo2.p = this.r;
        this.s = "c12928";
        if (feedData.getType() == 1) {
            this.f19172g.n = feedData.getQuote_pid();
            if (feedData.getQuote_user() == null) {
                str = "";
            } else if (StringHelper.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a97);
            } else {
                str = feedData.getQuote_user().getName_show();
            }
            this.f19172g.f29827g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f8e, new Object[]{str, feedData.getQuote_content()});
            if (TextUtils.isGraphic(this.f19172g.f29827g)) {
                OriginalThreadInfo originalThreadInfo3 = this.f19172g;
                originalThreadInfo3.f29827g = originalThreadInfo3.f29827g.replace("\n", " ");
            }
            if (feedData.getIsFloor()) {
                this.a = v;
            } else {
                this.a = w;
            }
        } else {
            this.f19172g.n = "0";
            if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                this.f19172g.f29827g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f112c, new Object[]{feedData.getOriginalThreadInfo().f29822b});
            } else {
                this.f19172g.f29827g = feedData.getTitle();
            }
            this.a = x;
        }
        this.f19172g.r();
    }

    public void D(AgreeList agreeList) {
        User user;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeList) == null) || agreeList == null) {
            return;
        }
        this.m = agreeList.id.longValue();
        MetaData metaData = new MetaData();
        this.f19167b = metaData;
        metaData.parserProtobuf(agreeList.agreeer);
        this.f19169d = agreeList.time.intValue() * 1000;
        Post post = agreeList.post_info;
        if (post != null) {
            this.l = String.valueOf(post.id);
            if (!ListUtils.isEmpty(agreeList.post_info.content) && ListUtils.getItem(agreeList.post_info.content, 0) != null && (user = agreeList.post_info.author) != null) {
                String str = user.name_show;
                if (m.isEmpty(str)) {
                    str = agreeList.post_info.author.name;
                }
                this.f19171f = str + "：" + agreeList.post_info.content.get(0).text;
            }
            this.o = agreeList.post_info.quote_id;
        }
        ThreadData threadData = new ThreadData();
        threadData.parserProtobuf(agreeList.thread_info);
        this.f19172g = OriginalThreadInfo.l(threadData);
        this.i = threadData.getAuthor();
        this.f19173h = threadData.getForum_name();
        this.k = threadData.getId();
        this.j = threadData.threadType;
        this.q = threadData.isUgcThreadType();
        this.r = threadData.getBaijiahaoData();
        this.s = "c12927";
        if (agreeList.type.intValue() == 3) {
            this.a = t;
            this.f19170e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00df);
            if (this.q) {
                this.f19170e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00dd);
                return;
            }
            return;
        }
        this.a = u;
        this.f19170e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00de);
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.p = z;
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19173h : (String) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m : invokeV.longValue;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.r : (BaijiahaoData) invokeV.objValue;
    }

    public int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.intValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19169d : invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f19170e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (BdUniqueId) invokeV.objValue;
    }

    public OriginalThreadInfo i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f19172g : (OriginalThreadInfo) invokeV.objValue;
    }

    public boolean isBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f19168c : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public MetaData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f19167b : (MetaData) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f19171f : (String) invokeV.objValue;
    }

    public MetaData y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.i : (MetaData) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k : (String) invokeV.objValue;
    }
}
