package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.a0.e0.m;
import d.a.p0.a0.e0.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class RecommendTopicData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f12260a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendTopicListData> f12261b;

    /* loaded from: classes3.dex */
    public static class RecommendTopicListData implements Serializable, Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<RecommendTopicListData> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public long discussNum;
        public int tag;
        public String topicDesc;
        public long topicId;
        public String topicName;
        public String topicPic;
        public int type;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<RecommendTopicListData> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
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
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public RecommendTopicListData createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new RecommendTopicListData(parcel) : (RecommendTopicListData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public RecommendTopicListData[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new RecommendTopicListData[i2] : (RecommendTopicListData[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(191594961, "Lcom/baidu/tbadk/core/data/RecommendTopicData$RecommendTopicListData;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(191594961, "Lcom/baidu/tbadk/core/data/RecommendTopicData$RecommendTopicListData;");
                    return;
                }
            }
            CREATOR = new a();
        }

        public RecommendTopicListData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public m getConvertedCardData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                m mVar = new m();
                mVar.f53820c = this.tag;
                mVar.f53818a = this.topicId;
                mVar.f53819b = this.topicName;
                return mVar;
            }
            return (m) invokeV.objValue;
        }

        public long getDiscussNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.discussNum : invokeV.longValue;
        }

        public int getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tag : invokeV.intValue;
        }

        public String getTopicDesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.topicDesc : (String) invokeV.objValue;
        }

        public long getTopicId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.topicId : invokeV.longValue;
        }

        public String getTopicName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.topicName : (String) invokeV.objValue;
        }

        public String getTopicPic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.topicPic : (String) invokeV.objValue;
        }

        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.type : invokeV.intValue;
        }

        public void parseJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.topicId = jSONObject.optLong("topic_id");
            this.topicName = jSONObject.optString(IntentConfig.TOPIC_NAME);
            this.type = jSONObject.optInt("type");
            this.discussNum = jSONObject.optLong("discuss_num");
            this.tag = jSONObject.optInt("tag");
            this.topicDesc = jSONObject.optString("topic_desc");
            this.topicPic = jSONObject.optString("topic_pic");
        }

        public void parserProtoBuf(RecomTopicList recomTopicList) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, recomTopicList) == null) || recomTopicList == null) {
                return;
            }
            this.topicId = recomTopicList.topic_id.longValue();
            this.topicName = recomTopicList.topic_name;
            this.type = recomTopicList.type.intValue();
            this.discussNum = recomTopicList.discuss_num.longValue();
            this.tag = recomTopicList.tag.intValue();
            this.topicDesc = recomTopicList.topic_desc;
            this.topicPic = recomTopicList.topic_pic;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048587, this, parcel, i2) == null) {
                parcel.writeLong(this.topicId);
                parcel.writeString(this.topicName);
                parcel.writeInt(this.type);
                parcel.writeLong(this.discussNum);
                parcel.writeInt(this.tag);
                parcel.writeString(this.topicDesc);
                parcel.writeString(this.topicPic);
            }
        }

        public RecommendTopicListData(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.topicId = parcel.readLong();
            this.topicName = parcel.readString();
            this.type = parcel.readInt();
            this.discussNum = parcel.readLong();
            this.tag = parcel.readInt();
            this.topicDesc = parcel.readString();
            this.topicPic = parcel.readString();
        }
    }

    public RecommendTopicData() {
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
        this.f12261b = new ArrayList();
    }

    public n a() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = new n();
            nVar.f53823g = b();
            if (this.f12261b != null) {
                arrayList = new ArrayList();
                for (RecommendTopicListData recommendTopicListData : this.f12261b) {
                    if (recommendTopicListData != null) {
                        arrayList.add(recommendTopicListData.getConvertedCardData());
                    }
                }
            } else {
                arrayList = null;
            }
            nVar.f53824h = arrayList;
            return nVar;
        }
        return (n) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (StringUtils.isNull(this.f12260a)) {
                return TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title);
            }
            return this.f12260a;
        }
        return (String) invokeV.objValue;
    }

    public final boolean c(RecommendTopicListData recommendTopicListData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recommendTopicListData)) == null) ? recommendTopicListData == null || StringUtils.isNull(recommendTopicListData.getTopicName()) || recommendTopicListData.getTopicId() <= 0 : invokeL.booleanValue;
    }

    public void d(RecomTopicInfo recomTopicInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, recomTopicInfo) == null) || recomTopicInfo == null) {
            return;
        }
        this.f12260a = recomTopicInfo.recom_title;
        if (ListUtils.getCount(recomTopicInfo.topic_list) > 0) {
            for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                if (recomTopicList != null) {
                    RecommendTopicListData recommendTopicListData = new RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(recomTopicList);
                    if (!c(recommendTopicListData)) {
                        this.f12261b.add(recommendTopicListData);
                    }
                }
            }
        }
    }
}
