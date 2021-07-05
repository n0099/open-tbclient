package com.baidu.tbadk.core.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.ForumRalatedInfo;
import protobuf.GetLivableForumList.DataRes;
import protobuf.GetLivableForumList.GetLivableForumListResIdl;
/* loaded from: classes4.dex */
public class ResponseGetLivableForumList extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean available;
    public ArrayList<ForumData> data;
    public boolean hasMore;
    public int minLevel;
    public String tips;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseGetLivableForumList() {
        super(107129);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.available = false;
        this.data = new ArrayList<>();
    }

    public boolean getAvailabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.available : invokeV.booleanValue;
    }

    public ArrayList<ForumData> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.data : (ArrayList) invokeV.objValue;
    }

    public int getMiniLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.minLevel : invokeV.intValue;
    }

    public String getTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.tips : (String) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.hasMore : invokeV.booleanValue;
    }

    public void setAvailabel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (i2 == 1) {
                this.available = true;
            } else {
                this.available = false;
            }
        }
    }

    public void setData(List<ForumRalatedInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || list == null) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) != null) {
                ForumData forumData = new ForumData();
                forumData.setCurScore(list.get(i2).curScore.intValue());
                forumData.setImage_url(list.get(i2).avatar);
                forumData.setLevelupScore(list.get(i2).leftScore.intValue());
                forumData.setUser_level(list.get(i2).level.intValue());
                forumData.setName(list.get(i2).name);
                forumData.setId(list.get(i2).forumId.toString());
                this.data.add(forumData);
            }
        }
    }

    public void setHasMore(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 == 1) {
                this.hasMore = true;
            } else {
                this.hasMore = false;
            }
        }
    }

    public void setMiniLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.minLevel = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            GetLivableForumListResIdl getLivableForumListResIdl = (GetLivableForumListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLivableForumListResIdl.class);
            setError(getLivableForumListResIdl.error.errorno.intValue());
            setErrorString(getLivableForumListResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            DataRes dataRes = getLivableForumListResIdl.data;
            this.tips = dataRes.tips;
            setHasMore(dataRes.hasMore.intValue());
            setAvailabel(getLivableForumListResIdl.data.available.intValue());
            setData(getLivableForumListResIdl.data.likeList);
            setMiniLevel(getLivableForumListResIdl.data.minLevel.intValue());
        }
    }
}
