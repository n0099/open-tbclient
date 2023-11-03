package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rm6;
import com.baidu.tieba.yca;
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
/* loaded from: classes4.dex */
public class BannerListData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1630193525564805923L;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<AdvertAppInfo> advertAppList;
    public ArrayList<FeedForumData> feedForumList;
    public rm6 recomTopicData;

    /* loaded from: classes4.dex */
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
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, advertAppInfo, advertAppInfo2)) == null) {
                int i2 = 0;
                if (advertAppInfo != null) {
                    i = JavaTypesHelper.toInt(advertAppInfo.f, 0);
                } else {
                    i = 0;
                }
                if (advertAppInfo2 != null) {
                    i2 = JavaTypesHelper.toInt(advertAppInfo2.f, 0);
                }
                return i - i2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.advertAppList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<FeedForumData> getFeedForumList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.feedForumList;
        }
        return (List) invokeV.objValue;
    }

    public rm6 getRecomTopicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.recomTopicData;
        }
        return (rm6) invokeV.objValue;
    }

    public String getLastIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<AdvertAppInfo> arrayList = this.advertAppList;
            if (arrayList != null && arrayList.size() > 0) {
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
            return null;
        }
        return (String) invokeV.objValue;
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

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("app");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserProtobuf(BannerList bannerList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bannerList) == null) {
            List<AdvertAppInfo> g = yca.m().g();
            if (g != null) {
                g.clear();
            }
            if (bannerList == null) {
                return;
            }
            List<App> list = bannerList.app;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                        advertAppInfo.l(list.get(i));
                        this.advertAppList.add(advertAppInfo);
                        if (g != null) {
                            g.add(advertAppInfo);
                        }
                    }
                }
            }
            yca.m().f();
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
        if ((interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) && (arrayList = this.feedForumList) != null && str != null) {
            Iterator<FeedForumData> it = arrayList.iterator();
            while (it.hasNext()) {
                FeedForumData next = it.next();
                if (next != null && next.getForumId() != null && next.getForumId().equals(str)) {
                    next.setIsLike(i);
                    return;
                }
            }
        }
    }
}
