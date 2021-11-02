package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class BDVideoPlayerUbcContent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Builder mBuilder;
    public final JSONObject mExtStatisticsLog;
    public final String mFrom;
    public final String mPage;
    public final long mPlayerPrepareTime;
    public final IUbcPlayerStatusFetcher mPlayerStatusFetcher;
    public final String mPoster;
    public final int mSelectType;
    public final String mTitle;
    public final String mVid;

    /* renamed from: com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String extLog;
        public String from;
        public String page;
        public long playerPrepareTime;
        public IUbcPlayerStatusFetcher playerStatusFetcher;
        public String poster;
        public int selectType;
        public String title;
        public String url;
        public String vid;

        public Builder() {
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
            this.playerStatusFetcher = new PlayerStatusEmptyFetcher();
        }

        public BDVideoPlayerUbcContent build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new BDVideoPlayerUbcContent(this, null) : (BDVideoPlayerUbcContent) invokeV.objValue;
        }

        public BDVideoPlayerUbcContent buildEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new BDVideoPlayerUbcContent(new Builder().extLog(""), null) : (BDVideoPlayerUbcContent) invokeV.objValue;
        }

        public Builder extLog(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.extLog = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder from(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.from = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder id(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.vid = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder page(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.page = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder playerPrepareTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.playerPrepareTime = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder playerStatusFetcher(IUbcPlayerStatusFetcher iUbcPlayerStatusFetcher) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iUbcPlayerStatusFetcher)) == null) {
                this.playerStatusFetcher = iUbcPlayerStatusFetcher;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder poster(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.poster = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder selectType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.selectType = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder title(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.title = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder url(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.url = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public /* synthetic */ BDVideoPlayerUbcContent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    @NonNull
    public JSONObject createExtStatisticsLog(@NonNull Builder builder) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, builder)) == null) {
            try {
                if (!TextUtils.isEmpty(builder.extLog)) {
                    jSONObject = new JSONObject(builder.extLog);
                } else {
                    jSONObject = new JSONObject();
                }
                jSONObject.put(TiebaStatic.Params.VID, builder.vid);
                jSONObject.put("url", builder.url);
                jSONObject.put("netType", BDVideoPlayerUbcHelper.getNetType());
                if (TextUtils.isEmpty(jSONObject.optString("pdRec"))) {
                    jSONObject.put("pdRec", "unKnow");
                }
                return jSONObject;
            } catch (Exception e2) {
                e2.printStackTrace();
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @NonNull
    public JSONObject getExtStatisticsLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mExtStatisticsLog : (JSONObject) invokeV.objValue;
    }

    @NonNull
    public JSONObject getExtStatisticsLogClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? createExtStatisticsLog(this.mBuilder) : (JSONObject) invokeV.objValue;
    }

    @NonNull
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFrom : (String) invokeV.objValue;
    }

    @NonNull
    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPage : (String) invokeV.objValue;
    }

    @NonNull
    public IUbcPlayerStatusFetcher getPlayerFetcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPlayerStatusFetcher : (IUbcPlayerStatusFetcher) invokeV.objValue;
    }

    @NonNull
    public long getPlayerPrepareTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPlayerPrepareTime : invokeV.longValue;
    }

    @NonNull
    public String getPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPoster : (String) invokeV.objValue;
    }

    @NonNull
    public int getSelectType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSelectType : invokeV.intValue;
    }

    @NonNull
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    @NonNull
    public String getVid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mVid : (String) invokeV.objValue;
    }

    public BDVideoPlayerUbcContent(@NonNull Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBuilder = builder;
        this.mExtStatisticsLog = createExtStatisticsLog(builder);
        this.mVid = builder.vid;
        this.mFrom = builder.from;
        this.mPage = builder.page;
        this.mPoster = builder.poster;
        this.mTitle = builder.title;
        this.mPlayerPrepareTime = builder.playerPrepareTime;
        this.mPlayerStatusFetcher = builder.playerStatusFetcher;
        this.mSelectType = builder.selectType;
    }
}
