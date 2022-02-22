package com.baidu.android.imsdk.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PaInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<PaInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean acceptPush;
    public String avatar;
    public String classavatar;
    public int classshow;
    public String classtitle;
    public int classtype;
    public String description;
    public String detail;
    public int disturb;
    public int mHasIdentity;
    public String mIdentity;
    public long mLastRefreshTime;
    public boolean mMsgNotify;
    public int mRejectMenu;
    public String mRepliesStr;
    public String mSchema;
    public int mShield;
    public long mShieldTime;
    public int mSubscribe;
    public String mThirdExt;
    public String mVipId;
    public int markTop;
    public long markTopTime;
    public String name;
    public String nickName;
    public String paExt;
    public long paId;
    public int status;
    public long subcribeTime;
    public int subsetType;
    public int subtype;
    public long tpl;
    public String url;
    public String vPortrait;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(761306116, "Lcom/baidu/android/imsdk/pubaccount/PaInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(761306116, "Lcom/baidu/android/imsdk/pubaccount/PaInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<PaInfo>() { // from class: com.baidu.android.imsdk.pubaccount.PaInfo.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PaInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? PaInfo.readFromParcel(parcel) : (PaInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PaInfo[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new PaInfo[i2] : (PaInfo[]) invokeI.objValue;
            }
        };
    }

    public PaInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.subsetType = 0;
        this.mLastRefreshTime = -1L;
        this.mVipId = "";
        this.vPortrait = "";
        this.mHasIdentity = 0;
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mIdentity = "";
        this.mSubscribe = 0;
        this.mThirdExt = "";
        this.mSchema = "";
    }

    public static PaInfo readFromParcel(Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, parcel)) == null) {
            PaInfo paInfo = new PaInfo();
            paInfo.setPaId(parcel.readLong());
            paInfo.setNickName(parcel.readString());
            paInfo.setAvatar(parcel.readString());
            paInfo.setAcceptPush(parcel.readInt() == 1);
            paInfo.setDescription(parcel.readString());
            paInfo.setUrl(parcel.readString());
            paInfo.setSubcribeTime(parcel.readLong());
            paInfo.setDetail(parcel.readString());
            paInfo.setUsername(parcel.readString());
            paInfo.setTPL(parcel.readLong());
            paInfo.setDisturb(parcel.readInt());
            paInfo.setSubtype(parcel.readInt());
            paInfo.setClassType(parcel.readInt());
            paInfo.setClasstitle(parcel.readString());
            paInfo.setClassAvatar(parcel.readString());
            paInfo.setStatus(parcel.readInt());
            paInfo.setMsgNotify(parcel.readInt() == 1);
            paInfo.setMarkTop(parcel.readInt());
            paInfo.setMarkTopTime(parcel.readLong());
            paInfo.setRepliesStr(parcel.readString());
            paInfo.setLastRefreshTime(parcel.readLong());
            paInfo.setSubsetType(parcel.readInt());
            paInfo.setPaExt(parcel.readString());
            paInfo.setVPortrait(parcel.readString());
            paInfo.setVipId(parcel.readString());
            paInfo.setHasIdentity(parcel.readInt());
            paInfo.setShield(parcel.readInt());
            paInfo.setShieldTime(parcel.readLong());
            paInfo.setIdentity(parcel.readString());
            paInfo.setSubscribe(parcel.readInt());
            paInfo.setThirdExt(parcel.readString());
            paInfo.setSchema(parcel.readString());
            paInfo.setRejectMenu(parcel.readInt());
            return paInfo;
        }
        return (PaInfo) invokeL.objValue;
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

    public String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.avatar : (String) invokeV.objValue;
    }

    public String getClassTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.classtitle : (String) invokeV.objValue;
    }

    public int getClassType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.classtype : invokeV.intValue;
    }

    public String getClassavatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.classavatar : (String) invokeV.objValue;
    }

    public int getClassshow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.classshow : invokeV.intValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.description : (String) invokeV.objValue;
    }

    public String getDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.detail : (String) invokeV.objValue;
    }

    public int getDisturb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.disturb : invokeV.intValue;
    }

    public int getHasIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mHasIdentity : invokeV.intValue;
    }

    public String getIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mIdentity : (String) invokeV.objValue;
    }

    public long getLastRefreshTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mLastRefreshTime : invokeV.longValue;
    }

    public int getMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.markTop : invokeV.intValue;
    }

    public long getMarkTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.markTopTime : invokeV.longValue;
    }

    public String getNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.nickName : (String) invokeV.objValue;
    }

    public String getPaExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.paExt : (String) invokeV.objValue;
    }

    public long getPaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.paId : invokeV.longValue;
    }

    public int getRejectMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mRejectMenu : invokeV.intValue;
    }

    public String getRepliesStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mRepliesStr : (String) invokeV.objValue;
    }

    public String getSchema() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (TextUtils.isEmpty(this.mSchema) && !TextUtils.isEmpty(this.mThirdExt)) {
                try {
                    this.mSchema = new JSONObject(this.mThirdExt).optString("homepage", "");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.mSchema;
        }
        return (String) invokeV.objValue;
    }

    public int getShield() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mShield : invokeV.intValue;
    }

    public long getShieldTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mShieldTime : invokeV.longValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.status : invokeV.intValue;
    }

    public long getSubcribeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.subcribeTime : invokeV.longValue;
    }

    public int getSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mSubscribe : invokeV.intValue;
    }

    public int getSubsetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.subsetType : invokeV.intValue;
    }

    public int getSubtype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.subtype : invokeV.intValue;
    }

    public long getTPL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.tpl : invokeV.longValue;
    }

    public String getThirdExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mThirdExt : (String) invokeV.objValue;
    }

    public String getThirdId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (!TextUtils.isEmpty(this.mThirdExt)) {
                try {
                    return new JSONObject(this.mThirdExt).optString("third_id", "");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public String getUsername() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public String getVPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.vPortrait : (String) invokeV.objValue;
    }

    public String getVipId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mVipId : (String) invokeV.objValue;
    }

    public boolean isAcceptPush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.acceptPush : invokeV.booleanValue;
    }

    public boolean isMsgNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mMsgNotify : invokeV.booleanValue;
    }

    public void setAcceptPush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.acceptPush = z;
        }
    }

    public void setAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.avatar = str;
        }
    }

    public void setClassAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.classavatar = str;
        }
    }

    public void setClassType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.classtype = i2;
        }
    }

    public void setClassshow(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.classshow = i2;
        }
    }

    public void setClasstitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.classtitle = str;
        }
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.description = str;
        }
    }

    public void setDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.detail = str;
        }
    }

    public void setDisturb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.disturb = i2;
        }
    }

    public void setHasIdentity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.mHasIdentity = i2;
        }
    }

    public void setIdentity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mIdentity = str;
        }
    }

    public void setLastRefreshTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048623, this, j2) == null) {
            this.mLastRefreshTime = j2;
        }
    }

    public void setMarkTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            this.markTop = i2;
        }
    }

    public void setMarkTopTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048625, this, j2) == null) {
            this.markTopTime = j2;
        }
    }

    public void setMsgNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.mMsgNotify = z;
        }
    }

    public void setNickName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.nickName = str;
        }
    }

    public void setPaExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.paExt = str;
        }
    }

    public void setPaId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j2) == null) {
            this.paId = j2;
        }
    }

    public void setRejectMenu(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.mRejectMenu = i2;
        }
    }

    public void setRepliesStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.mRepliesStr = str;
        }
    }

    public void setSchema(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.mSchema = str;
        }
    }

    public void setShield(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.mShield = i2;
        }
    }

    public void setShieldTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j2) == null) {
            this.mShieldTime = j2;
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.status = i2;
        }
    }

    public void setSubcribeTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048636, this, j2) == null) {
            this.subcribeTime = j2;
        }
    }

    public void setSubscribe(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.mSubscribe = i2;
        }
    }

    public void setSubsetType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.subsetType = i2;
        }
    }

    public void setSubtype(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.subtype = i2;
        }
    }

    public void setTPL(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048640, this, j2) == null) {
            this.tpl = j2;
        }
    }

    public void setThirdExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.mThirdExt = str;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                setSchema(new JSONObject(str).optString("homepage", ""));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.url = str;
        }
    }

    public void setUsername(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.name = str;
        }
    }

    public void setVPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.vPortrait = str;
        }
    }

    public void setVipId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.mVipId = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return "PaInfo [pdId=" + this.paId + " nickName=" + this.nickName + " disturb= " + this.disturb + " description=" + this.description + " acceptPush=" + this.acceptPush + " url=" + this.url + " subscribeTime" + this.subcribeTime + " classtype= " + this.classtype + "  classtitle= " + this.classtitle + " markTop= " + this.markTop + " markTopTime= " + this.markTopTime + "  classavatar= " + this.classavatar + " mMsgNotify= " + this.mMsgNotify + " mRepliesStr= " + this.mRepliesStr + " mLastRefreshTime= " + this.mLastRefreshTime + " subsetType= " + this.subsetType + " paExt= " + this.paExt + " vPortrait= " + this.vPortrait + " mHasIdentity= " + this.mHasIdentity + " mShield= " + this.mShield + " mShieldTime " + this.mShieldTime + " mIdentity= " + this.mIdentity + " mVipId= " + this.mVipId + ", schema=" + this.mSchema + ", mSubscribe=" + this.mSubscribe + ", mThirdExt=" + this.mThirdExt + ", mRejectMenu=" + this.mRejectMenu + "  ]";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048647, this, parcel, i2) == null) {
            parcel.writeLong(this.paId);
            parcel.writeString(this.nickName);
            parcel.writeString(this.avatar);
            parcel.writeInt(this.acceptPush ? 1 : 0);
            parcel.writeString(this.description);
            parcel.writeString(this.url);
            parcel.writeLong(this.subcribeTime);
            parcel.writeString(this.detail);
            parcel.writeString(this.name);
            parcel.writeLong(this.tpl);
            parcel.writeInt(this.disturb);
            parcel.writeInt(this.subtype);
            parcel.writeInt(this.classtype);
            parcel.writeString(this.classtitle);
            parcel.writeString(this.classavatar);
            parcel.writeInt(this.status);
            parcel.writeInt(this.mMsgNotify ? 1 : 0);
            parcel.writeLong(this.markTopTime);
            parcel.writeInt(this.markTop);
            parcel.writeString(this.mRepliesStr);
            parcel.writeLong(this.mLastRefreshTime);
            parcel.writeInt(this.subsetType);
            parcel.writeString(this.paExt);
            parcel.writeString(this.vPortrait);
            parcel.writeString(this.mVipId);
            parcel.writeInt(this.mHasIdentity);
            parcel.writeInt(this.mShield);
            parcel.writeLong(this.mShieldTime);
            parcel.writeString(this.mIdentity);
            parcel.writeString(this.mThirdExt);
            parcel.writeString(this.mSchema);
            parcel.writeInt(this.mSubscribe);
            parcel.writeInt(this.mRejectMenu);
        }
    }
}
