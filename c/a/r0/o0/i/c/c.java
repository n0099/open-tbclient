package c.a.r0.o0.i.c;

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
import tbclient.GetInfluenceRank.DataRes;
import tbclient.NewGodInfo;
import tbclient.RankRuler;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f22828a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f22829b;

    /* renamed from: c  reason: collision with root package name */
    public b f22830c;

    /* renamed from: d  reason: collision with root package name */
    public String f22831d;

    /* renamed from: e  reason: collision with root package name */
    public String f22832e;

    /* renamed from: f  reason: collision with root package name */
    public long f22833f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22834g;

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
        this.f22829b = new ArrayList();
        this.f22834g = true;
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
            bVar.f22820a = user.level_influence;
            bVar.f22822c = b(user);
            boolean z = true;
            if (!bVar.f22826g && (newGodInfo = user.new_god_data) != null && newGodInfo.status.intValue() == 3) {
                bVar.f22823d = user.new_god_data.field_name + r0.b(user.new_god_data);
                bVar.f22827h = true;
            }
            if (user.influence == null) {
                bVar.f22824e = "";
            } else {
                bVar.f22824e = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), StringHelper.numFormatOverWanNa(user.influence.intValue()));
            }
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(user);
            Integer num = user.has_concerned;
            metaData.setIsLike((num == null || num.intValue() == 0) ? false : false);
            bVar.f22825f = metaData;
            if (metaData.getAvater() != null && metaData.getAvater().startsWith("http")) {
                bVar.f22821b = metaData.getAvater();
            } else {
                bVar.f22821b = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
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
            String str = TextUtils.isEmpty("") ? user.name_show : "";
            return TextUtils.isEmpty(str) ? TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt) : str;
        }
        return (String) invokeL.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f22828a = new a();
        if (!ListUtils.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
            this.f22828a.f22815b = b(dataRes.user_rank.get(0));
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(dataRes.user_rank.get(0));
            this.f22828a.f22816c = metaData;
            String avatarH = metaData.getAvatarH();
            if (TextUtils.isEmpty(avatarH)) {
                avatarH = metaData.getAvater();
            }
            if (avatarH != null && avatarH.startsWith("http")) {
                this.f22828a.f22818e = avatarH;
            } else {
                a aVar = this.f22828a;
                aVar.f22818e = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
            }
        }
        a aVar2 = this.f22828a;
        Long l = dataRes.timestamp;
        aVar2.f22817d = l == null ? 0L : l.longValue();
        this.f22828a.f22819f = dataRes.field_info;
        if (!ListUtils.isEmpty(dataRes.user_rank)) {
            for (User user : dataRes.user_rank) {
                if (user != null) {
                    this.f22829b.add(a(user));
                }
            }
        }
        this.f22830c = a(dataRes.current_user);
        RankRuler rankRuler = dataRes.rank_description;
        if (rankRuler != null) {
            this.f22831d = rankRuler.top_link;
            this.f22832e = rankRuler.bottom_link;
        }
        Long l2 = dataRes.timestamp;
        this.f22833f = l2 != null ? l2.longValue() : 0L;
        Boolean bool = dataRes.has_more;
        this.f22834g = bool != null ? bool.booleanValue() : false;
    }
}
