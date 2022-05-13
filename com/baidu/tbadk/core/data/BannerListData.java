package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ja8;
import com.repackage.kg;
import com.repackage.ky5;
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
/* loaded from: classes3.dex */
public class BannerListData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1630193525564805923L;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<AdvertAppInfo> advertAppList;
    public ArrayList<FeedForumData> feedForumList;
    public ky5 recomTopicData;

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                return (advertAppInfo != null ? kg.e(advertAppInfo.f, 0) : 0) - (advertAppInfo2 != null ? kg.e(advertAppInfo2.f, 0) : 0);
            }
            return invokeLL.intValue;
        }
    }

    public BannerListData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            for (int i = 0; i < size; i++) {
                if (!TextUtils.isEmpty(this.advertAppList.get(i).a)) {
                    sb.append(this.advertAppList.get(i).a);
                    if (i != size - 1) {
                        sb.append(",");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ky5 getRecomTopicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.recomTopicData : (ky5) invokeV.objValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtobuf(BannerList bannerList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bannerList) == null) {
            List<AdvertAppInfo> f = ja8.l().f();
            if (f != null) {
                f.clear();
            }
            if (bannerList == null) {
                return;
            }
            List<App> list = bannerList.app;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                        advertAppInfo.s(list.get(i));
                        this.advertAppList.add(advertAppInfo);
                        if (f != null) {
                            f.add(advertAppInfo);
                        }
                    }
                }
            }
            ja8.l().e();
            Collections.sort(this.advertAppList, new a(this));
            List<FeedForumInfo> list2 = bannerList.feed_forum;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    if (list2.get(i2) != null) {
                        FeedForumData feedForumData = new FeedForumData();
                        feedForumData.parseFromFeedForumInfo(list2.get(i2));
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

    public void setFeedForumLiked(String str, int i) {
        ArrayList<FeedForumData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) || (arrayList = this.feedForumList) == null || str == null) {
            return;
        }
        Iterator<FeedForumData> it = arrayList.iterator();
        while (it.hasNext()) {
            FeedForumData next = it.next();
            if (next != null && next.getForumId() != null && next.getForumId().equals(str)) {
                next.setIsLike(i);
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
            for (int i = 0; i < optJSONArray.length(); i++) {
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
