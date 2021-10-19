package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import c.a.e.e.m.b;
import c.a.r0.b0.e0.n;
import c.a.r0.z2.y;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FeedForumInfo;
/* loaded from: classes6.dex */
public class BannerListData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1630193525564805923L;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<AdvertAppInfo> advertAppList;
    public ArrayList<FeedForumData> feedForumList;
    public n recomTopicData;

    /* loaded from: classes6.dex */
    public class a implements Comparator<AdvertAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(BannerListData bannerListData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerListData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(AdvertAppInfo advertAppInfo, AdvertAppInfo advertAppInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, advertAppInfo, advertAppInfo2)) == null) {
                return (advertAppInfo != null ? b.e(advertAppInfo.d4, 0) : 0) - (advertAppInfo2 != null ? b.e(advertAppInfo2.d4, 0) : 0);
            }
            return invokeLL.intValue;
        }
    }

    public BannerListData() {
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
        this.advertAppList = new ArrayList<>();
        this.feedForumList = new ArrayList<>();
    }

    public ArrayList<AdvertAppInfo> getAllAdvertList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.advertAppList : (ArrayList) invokeV.objValue;
    }

    public List<FeedForumData> getFeedForumList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.feedForumList : (List) invokeV.objValue;
    }

    public String getLastIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<AdvertAppInfo> arrayList = this.advertAppList;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int size = this.advertAppList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!TextUtils.isEmpty(this.advertAppList.get(i2).X3)) {
                    sb.append(this.advertAppList.get(i2).X3);
                    if (i2 != size - 1) {
                        sb.append(",");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public n getRecomTopicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.recomTopicData : (n) invokeV.objValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void parserProtobuf(BannerList bannerList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bannerList) == null) {
            List<AdvertAppInfo> h2 = y.o().h();
            if (h2 != null) {
                h2.clear();
            }
            if (bannerList == null) {
                return;
            }
            List<App> list = bannerList.app;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2) != null) {
                        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                        advertAppInfo.U4(list.get(i2));
                        this.advertAppList.add(advertAppInfo);
                        if (h2 != null) {
                            h2.add(advertAppInfo);
                        }
                    }
                }
            }
            y.o().g();
            Collections.sort(this.advertAppList, new a(this));
            List<FeedForumInfo> list2 = bannerList.feed_forum;
            if (list2 != null && list2.size() > 0) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    if (list2.get(i3) != null) {
                        FeedForumData feedForumData = new FeedForumData();
                        feedForumData.parseFromFeedForumInfo(list2.get(i3));
                        this.feedForumList.add(feedForumData);
                    }
                }
            }
            if (bannerList.hot_topic != null) {
                RecommendTopicData recommendTopicData = new RecommendTopicData();
                recommendTopicData.d(bannerList.hot_topic);
                this.recomTopicData = recommendTopicData.a();
            }
        }
    }

    public void setFeedForumLiked(String str, int i2) {
        ArrayList<FeedForumData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || (arrayList = this.feedForumList) == null || str == null) {
            return;
        }
        Iterator<FeedForumData> it = arrayList.iterator();
        while (it.hasNext()) {
            FeedForumData next = it.next();
            if (next != null && next.getForumId() != null && next.getForumId().equals(str)) {
                next.setIsLike(i2);
                return;
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("app");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
