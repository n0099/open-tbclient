package com.baidu.mobads.sdk.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BDDialogParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIM_STYLE_BREATHE = 1;
    public static final int ANIM_STYLE_GUIDE = 3;
    public static final int ANIM_STYLE_NONE = 0;
    public static final int ANIM_STYLE_SWIPE = 2;
    public static final int TYPE_BOTTOM_POPUP = 0;
    public static final int TYPE_CENTER_DECORATE = 2;
    public static final int TYPE_CENTER_NORMAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Builder mBuilder;

    /* renamed from: com.baidu.mobads.sdk.api.BDDialogParams$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mDlDialogAnimStyle;
        public int mDlDialogType;

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
            this.mDlDialogType = 0;
            this.mDlDialogAnimStyle = 0;
        }

        public BDDialogParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new BDDialogParams(this, null);
            }
            return (BDDialogParams) invokeV.objValue;
        }

        public Builder setDlDialogAnimStyle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.mDlDialogAnimStyle = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDlDialogType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.mDlDialogType = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    public BDDialogParams(Builder builder) {
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
        this.mBuilder = builder;
    }

    public /* synthetic */ BDDialogParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.mBuilder.mDlDialogType);
                jSONObject.put("anim_style", this.mBuilder.mDlDialogAnimStyle);
            } catch (JSONException e) {
                br.a().a(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
