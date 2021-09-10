package c.a.r0.n0.i.c;

import android.text.TextUtils;
import c.a.q0.d1.r0;
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
    public a f22628a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f22629b;

    /* renamed from: c  reason: collision with root package name */
    public b f22630c;

    /* renamed from: d  reason: collision with root package name */
    public String f22631d;

    /* renamed from: e  reason: collision with root package name */
    public String f22632e;

    /* renamed from: f  reason: collision with root package name */
    public long f22633f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22634g;

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
        this.f22629b = new ArrayList();
        this.f22634g = true;
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
            bVar.f22620a = user.level_influence;
            bVar.f22622c = b(user);
            BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
            boolean z = false;
            if (baijiahaoInfo != null) {
                bVar.f22623d = baijiahaoInfo.auth_desc;
                Integer num = baijiahaoInfo.auth_id;
                bVar.f22626g = (num == null || num.intValue() == 0) ? false : true;
            }
            if (!bVar.f22626g && (newGodInfo = user.new_god_data) != null && newGodInfo.status.intValue() == 3) {
                bVar.f22623d = user.new_god_data.field_name + r0.c(user.new_god_data);
                bVar.f22627h = true;
            }
            if (user.influence == null) {
                bVar.f22624e = "";
            } else {
                bVar.f22624e = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), StringHelper.numFormatOverWanNa(user.influence.intValue()));
            }
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(user);
            Integer num2 = user.has_concerned;
            if (num2 != null && num2.intValue() != 0) {
                z = true;
            }
            metaData.setIsLike(z);
            bVar.f22625f = metaData;
            if (metaData.getAvater() != null && metaData.getAvater().startsWith("http")) {
                bVar.f22621b = metaData.getAvater();
            } else {
                bVar.f22621b = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
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
        this.f22628a = new a();
        if (!ListUtils.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
            this.f22628a.f22615b = b(dataRes.user_rank.get(0));
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(dataRes.user_rank.get(0));
            this.f22628a.f22616c = metaData;
            String avatarH = metaData.getAvatarH();
            if (TextUtils.isEmpty(avatarH)) {
                avatarH = metaData.getAvater();
            }
            if (avatarH != null && avatarH.startsWith("http")) {
                this.f22628a.f22618e = avatarH;
            } else {
                a aVar = this.f22628a;
                aVar.f22618e = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
            }
        }
        a aVar2 = this.f22628a;
        Long l = dataRes.timestamp;
        aVar2.f22617d = l == null ? 0L : l.longValue();
        this.f22628a.f22619f = dataRes.field_info;
        if (!ListUtils.isEmpty(dataRes.user_rank)) {
            for (User user : dataRes.user_rank) {
                if (user != null) {
                    this.f22629b.add(a(user));
                }
            }
        }
        this.f22630c = a(dataRes.current_user);
        RankRuler rankRuler = dataRes.rank_description;
        if (rankRuler != null) {
            this.f22631d = rankRuler.top_link;
            this.f22632e = rankRuler.bottom_link;
        }
        Long l2 = dataRes.timestamp;
        this.f22633f = l2 != null ? l2.longValue() : 0L;
        Boolean bool = dataRes.has_more;
        this.f22634g = bool != null ? bool.booleanValue() : false;
    }
}
