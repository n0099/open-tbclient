package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tieba.as4;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class ImMessageCenterShowItemData extends AbstractImageProvider implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int defaultDataType = 0;
    public static final int noDataIconType = 1;
    public static final int recForumDataType = 2;
    public static final int recForumNoMoreDataType = 4;
    public static final int recForumTitleType = 3;
    public static final long serialVersionUID = 3133087680118197014L;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatar;
    public int dataType;
    public long forumId;
    public String forumName;
    public String friendBjhAvatar;
    public String friendId;
    public String friendName;
    public String friendNameShow;
    public String friendPortrait;
    public int friendStatus;
    public ChatSetting groupSetting;
    public int hasMore;
    public int isLike;
    public boolean isSelected;
    public boolean isSelf;
    public long markTopIndex;
    public int memberCount;
    public String msgContent;
    public String ownerId;
    public String ownerName;
    public int relation;
    public int sendStatus;
    public long serverTime;
    public String slogan;
    public int status;
    public int threadCount;
    public String title;
    public int unReadCount;
    public int unReadCountExtra;
    public as4 userExtraData;
    public int userType;

    public ImMessageCenterShowItemData() {
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
        this.isSelected = false;
        this.dataType = 0;
    }

    public String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.avatar : (String) invokeV.objValue;
    }

    public int getDataType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.dataType : invokeV.intValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.forumId : invokeV.longValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.forumName : (String) invokeV.objValue;
    }

    public String getFriendBjhAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.friendBjhAvatar : (String) invokeV.objValue;
    }

    public String getFriendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.friendId : (String) invokeV.objValue;
    }

    public String getFriendName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.friendName : (String) invokeV.objValue;
    }

    public String getFriendNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!StringUtils.isNull(this.friendNameShow)) {
                return this.friendNameShow;
            }
            return this.friendName;
        }
        return (String) invokeV.objValue;
    }

    public String getFriendPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.friendPortrait : (String) invokeV.objValue;
    }

    public ChatSetting getGroupSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.groupSetting : (ChatSetting) invokeV.objValue;
    }

    public int getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.hasMore : invokeV.intValue;
    }

    public int getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.isLike : invokeV.intValue;
    }

    public long getMarkTopIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.markTopIndex : invokeV.longValue;
    }

    public int getMemberCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.memberCount : invokeV.intValue;
    }

    public String getMsgContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.msgContent : (String) invokeV.objValue;
    }

    public String getOwnerName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.ownerName : (String) invokeV.objValue;
    }

    public int getRelation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.relation : invokeV.intValue;
    }

    public int getSendStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.sendStatus : invokeV.intValue;
    }

    public long getServerTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.serverTime : invokeV.longValue;
    }

    public String getSlogan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.slogan : (String) invokeV.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.status : invokeV.intValue;
    }

    public int getThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.threadCount : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public int getUnReadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.unReadCount : invokeV.intValue;
    }

    public as4 getUserExtraData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.userExtraData : (as4) invokeV.objValue;
    }

    public int getUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.userType : invokeV.intValue;
    }

    public boolean isSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.isSelected : invokeV.booleanValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.isSelf : invokeV.booleanValue;
    }

    public void setAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.avatar = str;
        }
    }

    public void setDataType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.dataType = i;
        }
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            this.forumId = j;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setFriendBjhAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.friendBjhAvatar = str;
        }
    }

    public void setFriendId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.friendId = str;
        }
    }

    public void setFriendName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.friendName = str;
        }
    }

    public void setFriendNameShow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.friendNameShow = str;
        }
    }

    public void setFriendPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.friendPortrait = str;
        }
    }

    public void setGroupSetting(ChatSetting chatSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, chatSetting) == null) {
            this.groupSetting = chatSetting;
        }
    }

    public void setHasMore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.hasMore = i;
        }
    }

    public void setIsLike(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.isLike = i;
        }
    }

    public void setMarkTopIndex(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048618, this, j) == null) {
            this.markTopIndex = j;
        }
    }

    public void setMemberCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.memberCount = i;
        }
    }

    public void setMsgContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.msgContent = str;
        }
    }

    public void setOwnerId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.ownerId = str;
        }
    }

    public void setOwnerName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.ownerName = str;
        }
    }

    public void setRelation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.relation = i;
        }
    }

    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.isSelected = z;
        }
    }

    public void setSelf(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.isSelf = z;
        }
    }

    public void setSendStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.sendStatus = i;
        }
    }

    public void setServerTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
            this.serverTime = j;
        }
    }

    public void setSlogan(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.slogan = str;
        }
    }

    public void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.status = i;
        }
    }

    public void setThreadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.threadCount = i;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.title = str;
        }
    }

    public void setUnReadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.unReadCount = i;
        }
    }

    public void setUserExtraData(as4 as4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, as4Var) == null) {
            this.userExtraData = as4Var;
        }
    }

    public void setUserType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            this.userType = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public ImMessageCenterShowItemData m40clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (ImMessageCenterShowItemData) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return this;
            }
        }
        return (ImMessageCenterShowItemData) invokeV.objValue;
    }
}
