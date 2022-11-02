package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BDVideoPlayerUbcContent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mClarityKey;
    public final JSONObject mExtStatisticsLog;
    public final String mFrom;
    public final String mPage;
    public final long mPlayerPrepareTime;
    public final IUbcPlayerStatusFetcher mPlayerStatusFetcher;
    public final String mPoster;
    public final int mSelectType;
    public final String mTitle;
    public final String mType;
    public final String mVid;

    /* renamed from: com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String clarityKey;
        public String extLog;
        public String from;
        public String page;
        public long playerPrepareTime;
        public IUbcPlayerStatusFetcher playerStatusFetcher;
        public String poster;
        public int selectType;
        public String title;
        public String type;
        public String url;
        public String vid;

        public Builder() {
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
            this.playerStatusFetcher = new PlayerStatusEmptyFetcher();
        }

        public BDVideoPlayerUbcContent build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new BDVideoPlayerUbcContent(this, null);
            }
            return (BDVideoPlayerUbcContent) invokeV.objValue;
        }

        public BDVideoPlayerUbcContent buildEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new BDVideoPlayerUbcContent(new Builder().extLog(""), null);
            }
            return (BDVideoPlayerUbcContent) invokeV.objValue;
        }

        public Builder clarityKey(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.clarityKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder extLog(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.extLog = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder from(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.from = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder id(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.vid = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder page(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.page = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder playerPrepareTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.playerPrepareTime = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder playerStatusFetcher(@Nullable IUbcPlayerStatusFetcher iUbcPlayerStatusFetcher) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iUbcPlayerStatusFetcher)) == null) {
                this.playerStatusFetcher = iUbcPlayerStatusFetcher;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder poster(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.poster = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder selectType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                this.selectType = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder title(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.title = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder type(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.type = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder url(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.url = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public BDVideoPlayerUbcContent(@NonNull Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExtStatisticsLog = createExtStatisticsLog(builder.extLog, builder.vid, builder.url);
        this.mVid = builder.vid;
        this.mFrom = builder.from;
        this.mPage = builder.page;
        this.mPoster = builder.poster;
        this.mTitle = builder.title;
        this.mPlayerPrepareTime = builder.playerPrepareTime;
        this.mPlayerStatusFetcher = builder.playerStatusFetcher;
        this.mSelectType = builder.selectType;
        this.mType = builder.type;
        this.mClarityKey = builder.clarityKey;
    }

    public /* synthetic */ BDVideoPlayerUbcContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    @NonNull
    private JSONObject createExtStatisticsLog(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        InterceptResult invokeLLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, str, str2, str3)) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject = new JSONObject(str);
                } else {
                    jSONObject = new JSONObject();
                }
                jSONObject.put(TiebaStatic.Params.VID, str2);
                jSONObject.put("url", str3);
                jSONObject.put("netType", BDVideoPlayerUbcHelper.getNetType());
                if (TextUtils.isEmpty(jSONObject.optString("pdRec"))) {
                    jSONObject.put("pdRec", "unKnow");
                }
                return jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
                return new JSONObject();
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    @Nullable
    public String getClarityKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mClarityKey;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public JSONObject getExtStatisticsLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mExtStatisticsLog;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Nullable
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mFrom;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPage;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public IUbcPlayerStatusFetcher getPlayerFetcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mPlayerStatusFetcher;
        }
        return (IUbcPlayerStatusFetcher) invokeV.objValue;
    }

    @Nullable
    public long getPlayerPrepareTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mPlayerPrepareTime;
        }
        return invokeV.longValue;
    }

    @Nullable
    public String getPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mPoster;
        }
        return (String) invokeV.objValue;
    }

    public int getSelectType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mSelectType;
        }
        return invokeV.intValue;
    }

    @Nullable
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mType;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mVid;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public JSONObject getExtStatisticsLogClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = this.mExtStatisticsLog;
            if (jSONObject2 == null) {
                return jSONObject;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    jSONObject.put(next, this.mExtStatisticsLog.optString(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
