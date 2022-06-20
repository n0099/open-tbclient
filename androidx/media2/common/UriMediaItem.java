package androidx.media2.common;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.media2.common.MediaItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class UriMediaItem extends MediaItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Uri mUri;
    public final List<HttpCookie> mUriCookies;
    public final Map<String, String> mUriHeader;

    /* loaded from: classes.dex */
    public static final class Builder extends MediaItem.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Uri mUri;
        public List<HttpCookie> mUriCookies;
        public Map<String, String> mUriHeader;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NonNull Uri uri) {
            this(uri, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Uri) objArr2[0], (Map) objArr2[1], (List) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Builder(@NonNull Uri uri, @Nullable Map<String, String> map, @Nullable List<HttpCookie> list) {
            CookieHandler cookieHandler;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uri, map, list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Preconditions.checkNotNull(uri, "uri cannot be null");
            this.mUri = uri;
            if (list != null && (cookieHandler = CookieHandler.getDefault()) != null && !(cookieHandler instanceof CookieManager)) {
                throw new IllegalArgumentException("The cookie handler has to be of CookieManager type when cookies are provided");
            }
            this.mUri = uri;
            if (map != null) {
                this.mUriHeader = new HashMap(map);
            }
            if (list != null) {
                this.mUriCookies = new ArrayList(list);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public UriMediaItem build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new UriMediaItem(this) : (UriMediaItem) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setEndPosition(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? (Builder) super.setEndPosition(j) : (Builder) invokeJ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mediaMetadata)) == null) ? (Builder) super.setMetadata(mediaMetadata) : (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.common.MediaItem.Builder
        @NonNull
        public Builder setStartPosition(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? (Builder) super.setStartPosition(j) : (Builder) invokeJ.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UriMediaItem(Builder builder) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MediaItem.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUri = builder.mUri;
        this.mUriHeader = builder.mUriHeader;
        this.mUriCookies = builder.mUriCookies;
    }

    @NonNull
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mUri : (Uri) invokeV.objValue;
    }

    @Nullable
    public List<HttpCookie> getUriCookies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mUriCookies == null) {
                return null;
            }
            return new ArrayList(this.mUriCookies);
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public Map<String, String> getUriHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mUriHeader == null) {
                return null;
            }
            return new HashMap(this.mUriHeader);
        }
        return (Map) invokeV.objValue;
    }
}
