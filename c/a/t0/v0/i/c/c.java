package c.a.t0.v0.i.c;

import android.text.TextUtils;
import c.a.s0.d1.s0;
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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f24354b;

    /* renamed from: c  reason: collision with root package name */
    public b f24355c;

    /* renamed from: d  reason: collision with root package name */
    public String f24356d;

    /* renamed from: e  reason: collision with root package name */
    public String f24357e;

    /* renamed from: f  reason: collision with root package name */
    public long f24358f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24359g;

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
        this.f24354b = new ArrayList();
        this.f24359g = true;
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
            bVar.a = user.level_influence;
            bVar.f24348c = b(user);
            boolean z = true;
            if (!bVar.f24352g && (newGodInfo = user.new_god_data) != null && newGodInfo.status.intValue() == 3) {
                bVar.f24349d = user.new_god_data.field_name + s0.b(user.new_god_data);
                bVar.f24353h = true;
            }
            if (user.influence == null) {
                bVar.f24350e = "";
            } else {
                bVar.f24350e = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), StringHelper.numFormatOverWanNa(user.influence.intValue()));
            }
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(user);
            Integer num = user.has_concerned;
            metaData.setIsLike((num == null || num.intValue() == 0) ? false : false);
            bVar.f24351f = metaData;
            if (metaData.getAvater() != null && metaData.getAvater().startsWith("http")) {
                bVar.f24347b = metaData.getAvater();
            } else {
                bVar.f24347b = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
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
        this.a = new a();
        if (!ListUtils.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
            this.a.f24342b = b(dataRes.user_rank.get(0));
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(dataRes.user_rank.get(0));
            this.a.f24343c = metaData;
            String avatarH = metaData.getAvatarH();
            if (TextUtils.isEmpty(avatarH)) {
                avatarH = metaData.getAvater();
            }
            if (avatarH != null && avatarH.startsWith("http")) {
                this.a.f24345e = avatarH;
            } else {
                a aVar = this.a;
                aVar.f24345e = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
            }
        }
        a aVar2 = this.a;
        Long l = dataRes.timestamp;
        aVar2.f24344d = l == null ? 0L : l.longValue();
        this.a.f24346f = dataRes.field_info;
        if (!ListUtils.isEmpty(dataRes.user_rank)) {
            for (User user : dataRes.user_rank) {
                if (user != null) {
                    this.f24354b.add(a(user));
                }
            }
        }
        this.f24355c = a(dataRes.current_user);
        RankRuler rankRuler = dataRes.rank_description;
        if (rankRuler != null) {
            this.f24356d = rankRuler.top_link;
            this.f24357e = rankRuler.bottom_link;
        }
        Long l2 = dataRes.timestamp;
        this.f24358f = l2 != null ? l2.longValue() : 0L;
        Boolean bool = dataRes.has_more;
        this.f24359g = bool != null ? bool.booleanValue() : false;
    }
}
