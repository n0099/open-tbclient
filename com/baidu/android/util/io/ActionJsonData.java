package com.baidu.android.util.io;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes6.dex */
public class ActionJsonData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_DEFAULT = -1;
    public static final int STATUS_OK = 0;
    public static final String TAG = "ActionJsonData";
    public static final String TAG_COMMAND = "command";
    public static final String TAG_DATASET = "dataset";
    public static final String TAG_LINK = "link";
    public static final String TAG_NOTIFICATION = "notification";
    public static final String TAG_SIGN_IN = "sign_in";
    public static final String TAG_STATUS = "status";
    public static final String TAG_TEXT = "text";
    public static final String TAG_VERSION = "version";
    public transient /* synthetic */ FieldHolder $fh;
    public List<JSONObject> mDataset;
    public Link mLink;
    public int mSignInStatus;
    public int mStatus;
    public int mVersion;

    /* loaded from: classes6.dex */
    public static final class Link {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Notification mNotification;
        public SignIn mSignIn;

        public Link() {
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
    }

    /* loaded from: classes6.dex */
    public static final class Notification {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mCommand;
        public String mText;

        public Notification() {
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
    }

    /* loaded from: classes6.dex */
    public static final class SignIn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mCommand;

        public SignIn() {
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
    }

    public ActionJsonData() {
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
        this.mStatus = -1;
        this.mVersion = 0;
    }

    public static ActionJsonData fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            ArrayList arrayList = null;
            if (jSONObject == null) {
                return null;
            }
            ActionJsonData actionJsonData = new ActionJsonData();
            actionJsonData.setStatus(jSONObject.optInt("status", -1));
            actionJsonData.setVersion(jSONObject.optInt("version"));
            actionJsonData.setSignIn(jSONObject.optInt(TAG_SIGN_IN));
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("link"));
                String optString = jSONObject2.optString(TAG_NOTIFICATION);
                if (optString != null) {
                    JSONObject jSONObject3 = new JSONObject(optString);
                    Notification notification = new Notification();
                    notification.mText = jSONObject3.optString("text");
                    notification.mCommand = jSONObject3.optString("command");
                    SignIn signIn = new SignIn();
                    signIn.mCommand = new JSONObject(jSONObject2.optString(TAG_SIGN_IN)).optString("command");
                    Link link = new Link();
                    link.mNotification = notification;
                    link.mSignIn = signIn;
                    actionJsonData.setLink(link);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(TAG_DATASET);
            JSONArray optJSONArray = jSONObject.optJSONArray(TAG_DATASET);
            if (optJSONArray != null) {
                arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        arrayList.add(optJSONObject2);
                    }
                }
            } else if (optJSONObject != null) {
                arrayList = new ArrayList(1);
                arrayList.add(optJSONObject);
            }
            actionJsonData.setDataset(arrayList);
            return actionJsonData;
        }
        return (ActionJsonData) invokeL.objValue;
    }

    public List<JSONObject> getDataset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDataset : (List) invokeV.objValue;
    }

    public Link getLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLink : (Link) invokeV.objValue;
    }

    public int getSignInStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSignInStatus : invokeV.intValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mStatus : invokeV.intValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVersion : invokeV.intValue;
    }

    public void setDataset(List<JSONObject> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.mDataset = list;
        }
    }

    public void setLink(Link link) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, link) == null) {
            this.mLink = link;
        }
    }

    public void setSignIn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mSignInStatus = i2;
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mStatus = i2;
        }
    }

    public void setVersion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mVersion = i2;
        }
    }

    public static ActionJsonData fromJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return fromJson(new JSONObject(str));
            } catch (JSONException e2) {
                e2.toString();
                return null;
            }
        }
        return (ActionJsonData) invokeL.objValue;
    }
}
