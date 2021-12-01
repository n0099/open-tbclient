package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ThreadExpressionActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Zan;
/* loaded from: classes9.dex */
public class PraiseData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2658065756886586666L;
    public transient /* synthetic */ FieldHolder $fh;
    public int isLike;
    public long num;
    public String postId;
    public String title;
    public HashMap<String, MetaData> userMap;
    public ArrayList<MetaData> users;

    public PraiseData() {
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
        this.title = "";
        this.postId = "";
        this.num = 0L;
        this.users = new ArrayList<>();
        this.isLike = 0;
    }

    public int getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isLike : invokeV.intValue;
    }

    public long getNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.num : invokeV.longValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.postId : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public ArrayList<MetaData> getUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.users : (ArrayList) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.userMap : (HashMap) invokeV.objValue;
    }

    public boolean isPriaseDataValid() {
        InterceptResult invokeV;
        ArrayList<MetaData> arrayList;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.num > 0 && (arrayList = this.users) != null && arrayList.size() >= 1 : invokeV.booleanValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void parserProtobuf(Zan zan) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, zan) == null) || zan == null) {
            return;
        }
        this.num = zan.num.intValue();
        this.isLike = zan.is_liked.intValue();
        List<Long> list = zan.liker_id;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String l = list.get(i2).toString();
            if (this.userMap != null && l != null && !l.equals("0") && (metaData = this.userMap.get(l)) != null) {
                this.users.add(metaData);
            }
        }
    }

    public void setIsLike(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.isLike = i2;
        }
    }

    public void setNum(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.num = j2;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.postId = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.title = str;
        }
    }

    public void setUser(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) {
            this.users = arrayList;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.num = jSONObject.optLong("num", 0L);
            this.isLike = jSONObject.optInt(ThreadExpressionActivityConfig.IS_LIKED, 0);
            JSONArray jSONArray = jSONObject.getJSONArray("liker_id");
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String optString = jSONArray.optString(i2);
                if (this.userMap != null && optString != null && optString.length() > 0 && (metaData = this.userMap.get(optString)) != null) {
                    this.users.add(metaData);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
