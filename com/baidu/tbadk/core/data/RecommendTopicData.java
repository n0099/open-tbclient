package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.cp6;
import com.baidu.tieba.dp6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.RecomTopicInfo;
import tbclient.RecomTopicList;
/* loaded from: classes4.dex */
public class RecommendTopicData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<RecommendTopicListData> b;

    /* loaded from: classes4.dex */
    public static class RecommendTopicListData implements Serializable, Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<RecommendTopicListData> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public long discussNum;
        public int isVideoTopicInt;
        public int tag;
        public String topicDesc;
        public long topicId;
        public String topicName;
        public String topicPic;
        public int type;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes4.dex */
        public static class a implements Parcelable.Creator<RecommendTopicListData> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
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
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public RecommendTopicListData createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                    return new RecommendTopicListData(parcel);
                }
                return (RecommendTopicListData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public RecommendTopicListData[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    return new RecommendTopicListData[i];
                }
                return (RecommendTopicListData[]) invokeI.objValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public cp6 getConvertedCardData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                cp6 cp6Var = new cp6();
                cp6Var.c = this.tag;
                cp6Var.a = this.topicId;
                cp6Var.b = this.topicName;
                cp6Var.b(this.isVideoTopicInt);
                return cp6Var;
            }
            return (cp6) invokeV.objValue;
        }

        public long getDiscussNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.discussNum;
            }
            return invokeV.longValue;
        }

        public int getIsVideoTopicInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.isVideoTopicInt;
            }
            return invokeV.intValue;
        }

        public int getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.tag;
            }
            return invokeV.intValue;
        }

        public String getTopicDesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.topicDesc;
            }
            return (String) invokeV.objValue;
        }

        public long getTopicId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.topicId;
            }
            return invokeV.longValue;
        }

        public String getTopicName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.topicName;
            }
            return (String) invokeV.objValue;
        }

        public String getTopicPic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.topicPic;
            }
            return (String) invokeV.objValue;
        }

        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.type;
            }
            return invokeV.intValue;
        }

        public RecommendTopicListData(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        public void parseJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048586, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.topicId = jSONObject.optLong("topic_id");
            this.topicName = jSONObject.optString("topic_name");
            this.type = jSONObject.optInt("type");
            this.discussNum = jSONObject.optLong("discuss_num");
            this.tag = jSONObject.optInt("tag");
            this.topicDesc = jSONObject.optString("topic_desc");
            this.topicPic = jSONObject.optString("topic_pic");
            this.isVideoTopicInt = jSONObject.optInt("is_video_topic");
        }

        public void parserProtoBuf(RecomTopicList recomTopicList) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, recomTopicList) != null) || recomTopicList == null) {
                return;
            }
            this.topicId = recomTopicList.topic_id.longValue();
            this.topicName = recomTopicList.topic_name;
            this.type = recomTopicList.type.intValue();
            this.discussNum = recomTopicList.discuss_num.longValue();
            this.tag = recomTopicList.tag.intValue();
            this.topicDesc = recomTopicList.topic_desc;
            this.topicPic = recomTopicList.topic_pic;
            this.isVideoTopicInt = recomTopicList.is_video_topic.intValue();
        }

        public void setIsVideoTopicInt(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                this.isVideoTopicInt = i;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i) == null) {
                parcel.writeLong(this.topicId);
                parcel.writeString(this.topicName);
                parcel.writeInt(this.type);
                parcel.writeLong(this.discussNum);
                parcel.writeInt(this.tag);
                parcel.writeString(this.topicDesc);
                parcel.writeString(this.topicPic);
            }
        }
    }

    public RecommendTopicData() {
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
        this.b = new ArrayList();
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (StringUtils.isNull(this.a)) {
                return TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title);
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public dp6 a() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            dp6 dp6Var = new dp6();
            dp6Var.c = b();
            if (this.b != null) {
                arrayList = new ArrayList();
                for (RecommendTopicListData recommendTopicListData : this.b) {
                    if (recommendTopicListData != null) {
                        arrayList.add(recommendTopicListData.getConvertedCardData());
                    }
                }
            } else {
                arrayList = null;
            }
            dp6Var.d = arrayList;
            return dp6Var;
        }
        return (dp6) invokeV.objValue;
    }

    public final boolean c(RecommendTopicListData recommendTopicListData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recommendTopicListData)) == null) {
            if (recommendTopicListData != null && !StringUtils.isNull(recommendTopicListData.getTopicName()) && recommendTopicListData.getTopicId() > 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d(RecomTopicInfo recomTopicInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, recomTopicInfo) != null) || recomTopicInfo == null) {
            return;
        }
        this.a = recomTopicInfo.recom_title;
        if (ListUtils.getCount(recomTopicInfo.topic_list) > 0) {
            for (RecomTopicList recomTopicList : recomTopicInfo.topic_list) {
                if (recomTopicList != null) {
                    RecommendTopicListData recommendTopicListData = new RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(recomTopicList);
                    if (!c(recommendTopicListData)) {
                        this.b.add(recommendTopicListData);
                    }
                }
            }
        }
    }
}
