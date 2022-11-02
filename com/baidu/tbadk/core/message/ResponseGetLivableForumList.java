package com.baidu.tbadk.core.message;

import androidx.annotation.Nullable;
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
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.available = false;
        this.data = new ArrayList<>();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetLivableForumListResIdl getLivableForumListResIdl = (GetLivableForumListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLivableForumListResIdl.class);
            setError(getLivableForumListResIdl.error.errorno.intValue());
            setErrorString(getLivableForumListResIdl.error.usermsg);
            if (getError() != 0) {
                return getLivableForumListResIdl;
            }
            DataRes dataRes = getLivableForumListResIdl.data;
            this.tips = dataRes.tips;
            setHasMore(dataRes.hasMore.intValue());
            setAvailabel(getLivableForumListResIdl.data.available.intValue());
            setData(getLivableForumListResIdl.data.likeList);
            setMiniLevel(getLivableForumListResIdl.data.minLevel.intValue());
            return getLivableForumListResIdl;
        }
        return invokeIL.objValue;
    }

    public boolean getAvailabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.available;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<ForumData> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.data;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getMiniLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.minLevel;
        }
        return invokeV.intValue;
    }

    public String getTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.tips;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.hasMore;
        }
        return invokeV.booleanValue;
    }

    public void setAvailabel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i == 1) {
                this.available = true;
            } else {
                this.available = false;
            }
        }
    }

    public void setHasMore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i == 1) {
                this.hasMore = true;
            } else {
                this.hasMore = false;
            }
        }
    }

    public void setMiniLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.minLevel = i;
        }
    }

    public void setData(List<ForumRalatedInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    ForumData forumData = new ForumData();
                    forumData.setCurScore(list.get(i).curScore.intValue());
                    forumData.setImage_url(list.get(i).avatar);
                    forumData.setLevelupScore(list.get(i).leftScore.intValue());
                    forumData.setUser_level(list.get(i).level.intValue());
                    forumData.setName(list.get(i).name);
                    forumData.setId(list.get(i).forumId.toString());
                    this.data.add(forumData);
                }
            }
        }
    }
}
