package c.a.p0.m0.i.c;

import android.text.TextUtils;
import c.a.o0.b1.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BaijiahaoInfo;
import tbclient.GetInfluenceRank.DataRes;
import tbclient.NewGodInfo;
import tbclient.RankRuler;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f21730a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f21731b;

    /* renamed from: c  reason: collision with root package name */
    public b f21732c;

    /* renamed from: d  reason: collision with root package name */
    public String f21733d;

    /* renamed from: e  reason: collision with root package name */
    public String f21734e;

    /* renamed from: f  reason: collision with root package name */
    public long f21735f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21736g;

    public c() {
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
        this.f21731b = new ArrayList();
        this.f21736g = true;
    }

    public final b a(User user) {
        InterceptResult invokeL;
        NewGodInfo newGodInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, user)) == null) {
            if (user == null) {
                return null;
            }
            b bVar = new b();
            bVar.f21722a = user.level_influence;
            bVar.f21724c = b(user);
            BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
            boolean z = false;
            if (baijiahaoInfo != null) {
                bVar.f21725d = baijiahaoInfo.auth_desc;
                Integer num = baijiahaoInfo.auth_id;
                bVar.f21728g = (num == null || num.intValue() == 0) ? false : true;
            }
            if (!bVar.f21728g && (newGodInfo = user.new_god_data) != null && newGodInfo.status.intValue() == 3) {
                bVar.f21725d = user.new_god_data.field_name + q0.c(user.new_god_data);
                bVar.f21729h = true;
            }
            if (user.influence == null) {
                bVar.f21726e = "";
            } else {
                bVar.f21726e = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), StringHelper.numFormatOverWanNa(user.influence.intValue()));
            }
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(user);
            Integer num2 = user.has_concerned;
            if (num2 != null && num2.intValue() != 0) {
                z = true;
            }
            metaData.setIsLike(z);
            bVar.f21727f = metaData;
            if (metaData.getAvater() != null && metaData.getAvater().startsWith("http")) {
                bVar.f21723b = metaData.getAvater();
            } else {
                bVar.f21723b = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public final String b(User user) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, user)) == null) {
            if (user == null) {
                return "";
            }
            BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
            String str = baijiahaoInfo != null ? baijiahaoInfo.name : "";
            if (TextUtils.isEmpty(str)) {
                str = user.name_show;
            }
            return TextUtils.isEmpty(str) ? TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt) : str;
        }
        return (String) invokeL.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f21730a = new a();
        if (!ListUtils.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
            this.f21730a.f21717b = b(dataRes.user_rank.get(0));
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(dataRes.user_rank.get(0));
            this.f21730a.f21718c = metaData;
            String avatarH = metaData.getAvatarH();
            if (TextUtils.isEmpty(avatarH)) {
                avatarH = metaData.getAvater();
            }
            if (avatarH != null && avatarH.startsWith("http")) {
                this.f21730a.f21720e = avatarH;
            } else {
                a aVar = this.f21730a;
                aVar.f21720e = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
            }
        }
        a aVar2 = this.f21730a;
        Long l = dataRes.timestamp;
        aVar2.f21719d = l == null ? 0L : l.longValue();
        this.f21730a.f21721f = dataRes.field_info;
        if (!ListUtils.isEmpty(dataRes.user_rank)) {
            for (User user : dataRes.user_rank) {
                if (user != null) {
                    this.f21731b.add(a(user));
                }
            }
        }
        this.f21732c = a(dataRes.current_user);
        RankRuler rankRuler = dataRes.rank_description;
        if (rankRuler != null) {
            this.f21733d = rankRuler.top_link;
            this.f21734e = rankRuler.bottom_link;
        }
        Long l2 = dataRes.timestamp;
        this.f21735f = l2 != null ? l2.longValue() : 0L;
        Boolean bool = dataRes.has_more;
        this.f21736g = bool != null ? bool.booleanValue() : false;
    }
}
