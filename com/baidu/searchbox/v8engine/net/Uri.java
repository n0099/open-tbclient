package com.baidu.searchbox.v8engine.net;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
/* loaded from: classes9.dex */
public abstract class Uri implements Comparable<Uri> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final char[] HEX_DIGITS;
    public static final String NOT_CACHED;
    public static final int NOT_CALCULATED = -2;
    public static final int NOT_FOUND = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.v8engine.net.Uri$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static abstract class AbstractHierarchicalUri extends Uri {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AbstractHierarchicalUri() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.searchbox.v8engine.net.Uri, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Uri uri) {
            return super.compareTo(uri);
        }

        public String parseAuthority() {
            InterceptResult invokeV;
            String substring;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String encodedAuthority = getEncodedAuthority();
                if (encodedAuthority == null) {
                    return null;
                }
                int lastIndexOf = encodedAuthority.lastIndexOf(64);
                int indexOf = encodedAuthority.indexOf(58, lastIndexOf);
                if (indexOf == -1) {
                    substring = encodedAuthority.substring(lastIndexOf + 1);
                } else {
                    substring = encodedAuthority.substring(lastIndexOf + 1, indexOf);
                }
                if (lastIndexOf != -1) {
                    str = encodedAuthority.substring(0, lastIndexOf) + "@";
                } else {
                    str = "";
                }
                String str2 = str + a.b(substring);
                if (indexOf != -1) {
                    return str2 + encodedAuthority.substring(indexOf + 1);
                }
                return str2;
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ AbstractHierarchicalUri(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class AbstractPart {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile String decoded;
        public volatile String encoded;

        public AbstractPart(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.encoded = str;
            this.decoded = str2;
        }
    }

    /* loaded from: classes9.dex */
    public static class AuthorityPart extends AbstractPart {
        public static /* synthetic */ Interceptable $ic;
        public static final AuthorityPart EMPTY;
        public static final AuthorityPart NULL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1476372032, "Lcom/baidu/searchbox/v8engine/net/Uri$AuthorityPart;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1476372032, "Lcom/baidu/searchbox/v8engine/net/Uri$AuthorityPart;");
                    return;
                }
            }
            NULL = new AuthorityPart(null, null);
            EMPTY = new AuthorityPart("", "");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthorityPart(String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static AuthorityPart from(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
                if (str == null) {
                    return NULL;
                }
                if (str.length() == 0) {
                    return EMPTY;
                }
                return new AuthorityPart(str, str2);
            }
            return (AuthorityPart) invokeLL.objValue;
        }

        public static AuthorityPart fromEncoded(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? from(str, Uri.NOT_CACHED) : (AuthorityPart) invokeL.objValue;
        }

        public String getEncoded() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.encoded != Uri.NOT_CACHED) {
                    return this.encoded;
                }
                String encode = Uri.encode(this.decoded);
                this.encoded = encode;
                return encode;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Part fragment;
        public Part opaquePart;
        public PathPart path;
        public Part query;
        public String scheme;

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
                }
            }
        }

        private boolean hasSchemeOrAuthority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.scheme != null : invokeV.booleanValue;
        }

        public Builder appendQueryParameter(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.opaquePart = null;
                String str3 = Uri.encode(str, null) + "=" + Uri.encode(str2, null);
                Part part = this.query;
                if (part == null) {
                    this.query = Part.fromEncoded(str3);
                    return this;
                }
                String encoded = part.getEncoded();
                if (encoded != null && encoded.length() != 0) {
                    this.query = Part.fromEncoded(encoded + "&" + str3);
                } else {
                    this.query = Part.fromEncoded(str3);
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Uri build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.opaquePart != null) {
                    if (this.scheme != null) {
                        return new OpaqueUri(this.scheme, this.opaquePart, this.fragment, null);
                    }
                    throw new UnsupportedOperationException("An opaque URI must have a scheme.");
                }
                PathPart pathPart = this.path;
                if (pathPart != null && pathPart != PathPart.NULL) {
                    if (hasSchemeOrAuthority()) {
                        pathPart = PathPart.makeAbsolute(pathPart);
                    }
                } else {
                    pathPart = PathPart.EMPTY;
                }
                return new HierarchicalUri(this.scheme, pathPart, this.query, this.fragment, null);
            }
            return (Uri) invokeV.objValue;
        }

        public Builder fragment(Part part) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, part)) == null) {
                this.fragment = part;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder path(PathPart pathPart) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pathPart)) == null) {
                this.opaquePart = null;
                this.path = pathPart;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder query(Part part) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, part)) == null) {
                this.opaquePart = null;
                this.query = part;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder scheme(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.scheme = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? build().toString() : (String) invokeV.objValue;
        }

        public Builder fragment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? fragment(Part.fromDecoded(str)) : (Builder) invokeL.objValue;
        }

        public Builder path(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? path(PathPart.fromDecoded(str)) : (Builder) invokeL.objValue;
        }

        public Builder query(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? query(Part.fromDecoded(str)) : (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class HierarchicalUri extends AbstractHierarchicalUri {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AuthorityPart authority;
        public final Part fragment;
        public final PathPart path;
        public final Part query;
        public final String scheme;
        public volatile String uriString;

        public /* synthetic */ HierarchicalUri(String str, PathPart pathPart, Part part, Part part2, AnonymousClass1 anonymousClass1) {
            this(str, pathPart, part, part2);
        }

        private void appendSspTo(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, sb) == null) {
                String parseAuthority = parseAuthority();
                if (parseAuthority != null) {
                    sb.append("//");
                    sb.append(parseAuthority);
                }
                String encoded = this.path.getEncoded();
                if (encoded != null) {
                    sb.append(encoded);
                }
                if (this.query.isEmpty()) {
                    return;
                }
                sb.append('?');
                sb.append(this.query.getEncoded());
            }
        }

        private String makeUriString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                StringBuilder sb = new StringBuilder();
                String str = this.scheme;
                if (str != null) {
                    sb.append(str);
                    sb.append(':');
                }
                appendSspTo(sb);
                if (!this.fragment.isEmpty()) {
                    sb.append('#');
                    sb.append(this.fragment.getEncoded());
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getEncodedAuthority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.authority.getEncoded() : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getScheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.scheme : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isHierarchical() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isRelative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.scheme == null : invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.uriString != Uri.NOT_CACHED) {
                    return this.uriString;
                }
                String makeUriString = makeUriString();
                this.uriString = makeUriString;
                return makeUriString;
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HierarchicalUri(String str, PathPart pathPart, Part part, Part part2) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, pathPart, part, part2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uriString = Uri.NOT_CACHED;
            this.scheme = str;
            this.authority = AuthorityPart.NULL;
            this.path = pathPart == null ? PathPart.NULL : pathPart;
            this.query = Part.nonNull(part);
            this.fragment = Part.nonNull(part2);
        }
    }

    /* loaded from: classes9.dex */
    public static class OpaqueUri extends Uri {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile String cachedString;
        public final Part fragment;
        public final String scheme;
        public final Part ssp;

        public /* synthetic */ OpaqueUri(String str, Part part, Part part2, AnonymousClass1 anonymousClass1) {
            this(str, part, part2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.searchbox.v8engine.net.Uri, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Uri uri) {
            return super.compareTo(uri);
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getEncodedAuthority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        public String getEncodedSchemeSpecificPart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ssp.getEncoded() : (String) invokeV.objValue;
        }

        public String getHost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        public String getPath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        public String getQuery() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getScheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.scheme : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isHierarchical() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isRelative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.scheme == null : invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.cachedString != Uri.NOT_CACHED) {
                    return this.cachedString;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.scheme);
                sb.append(':');
                sb.append(getEncodedSchemeSpecificPart());
                if (!this.fragment.isEmpty()) {
                    sb.append('#');
                    sb.append(this.fragment.getEncoded());
                }
                String sb2 = sb.toString();
                this.cachedString = sb2;
                return sb2;
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpaqueUri(String str, Part part, Part part2) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, part, part2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cachedString = Uri.NOT_CACHED;
            this.scheme = str;
            this.ssp = part;
            this.fragment = part2 == null ? Part.NULL : part2;
        }
    }

    /* loaded from: classes9.dex */
    public static class Part extends AbstractPart {
        public static /* synthetic */ Interceptable $ic;
        public static final Part EMPTY;
        public static final Part NULL;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public static class EmptyPart extends Part {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmptyPart(String str) {
                super(str, str, null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], (String) objArr2[1], (AnonymousClass1) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.searchbox.v8engine.net.Uri.Part
            public boolean isEmpty() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1835995347, "Lcom/baidu/searchbox/v8engine/net/Uri$Part;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1835995347, "Lcom/baidu/searchbox/v8engine/net/Uri$Part;");
                    return;
                }
            }
            NULL = new EmptyPart(null);
            EMPTY = new EmptyPart("");
        }

        public /* synthetic */ Part(String str, String str2, AnonymousClass1 anonymousClass1) {
            this(str, str2);
        }

        public static Part from(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
                if (str == null) {
                    return NULL;
                }
                if (str.length() == 0) {
                    return EMPTY;
                }
                if (str2 == null) {
                    return NULL;
                }
                if (str2.length() == 0) {
                    return EMPTY;
                }
                return new Part(str, str2);
            }
            return (Part) invokeLL.objValue;
        }

        public static Part fromDecoded(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? from(Uri.NOT_CACHED, str) : (Part) invokeL.objValue;
        }

        public static Part fromEncoded(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? from(str, Uri.NOT_CACHED) : (Part) invokeL.objValue;
        }

        public static Part nonNull(Part part) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, part)) == null) ? part == null ? NULL : part : (Part) invokeL.objValue;
        }

        public String getEncoded() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.encoded != Uri.NOT_CACHED) {
                    return this.encoded;
                }
                String encode = Uri.encode(this.decoded);
                this.encoded = encode;
                return encode;
            }
            return (String) invokeV.objValue;
        }

        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Part(String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class PathPart extends AbstractPart {
        public static /* synthetic */ Interceptable $ic;
        public static final PathPart EMPTY;
        public static final PathPart NULL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1269014408, "Lcom/baidu/searchbox/v8engine/net/Uri$PathPart;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1269014408, "Lcom/baidu/searchbox/v8engine/net/Uri$PathPart;");
                    return;
                }
            }
            NULL = new PathPart(null, null);
            EMPTY = new PathPart("", "");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PathPart(String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static PathPart from(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
                if (str == null) {
                    return NULL;
                }
                if (str.length() == 0) {
                    return EMPTY;
                }
                return new PathPart(str, str2);
            }
            return (PathPart) invokeLL.objValue;
        }

        public static PathPart fromDecoded(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? from(Uri.NOT_CACHED, str) : (PathPart) invokeL.objValue;
        }

        public static PathPart makeAbsolute(PathPart pathPart) {
            InterceptResult invokeL;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pathPart)) == null) {
                boolean z = pathPart.encoded != Uri.NOT_CACHED;
                String str3 = z ? pathPart.encoded : pathPart.decoded;
                if (str3 == null || str3.length() == 0 || str3.startsWith("/")) {
                    return pathPart;
                }
                if (!z) {
                    str = Uri.NOT_CACHED;
                } else {
                    str = "/" + pathPart.encoded;
                }
                if (!(pathPart.decoded != Uri.NOT_CACHED)) {
                    str2 = Uri.NOT_CACHED;
                } else {
                    str2 = "/" + pathPart.decoded;
                }
                return new PathPart(str, str2);
            }
            return (PathPart) invokeL.objValue;
        }

        public String getEncoded() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.encoded != Uri.NOT_CACHED) {
                    return this.encoded;
                }
                String encode = Uri.encode(this.decoded, "/");
                this.encoded = encode;
                return encode;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class StringUri extends AbstractHierarchicalUri {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AuthorityPart authority;
        public volatile int cachedSsi;
        public volatile String scheme;
        public final String uriString;

        public /* synthetic */ StringUri(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private String encodeAuthority(String str) {
            InterceptResult invokeL;
            String substring;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                int lastIndexOf = str.lastIndexOf(64);
                int indexOf = str.indexOf(58, lastIndexOf);
                if (indexOf == -1) {
                    substring = str.substring(lastIndexOf + 1);
                } else {
                    substring = str.substring(lastIndexOf + 1, indexOf);
                }
                if (lastIndexOf != -1) {
                    str2 = Uri.encode(str.substring(0, lastIndexOf)) + "@";
                } else {
                    str2 = "";
                }
                String str3 = str2 + a.b(substring);
                if (indexOf != -1) {
                    return str3 + str.substring(indexOf + 1);
                }
                return str3;
            }
            return (String) invokeL.objValue;
        }

        private int findSchemeSeparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                if (this.cachedSsi == -2) {
                    int indexOf = this.uriString.indexOf(58);
                    this.cachedSsi = indexOf;
                    return indexOf;
                }
                return this.cachedSsi;
            }
            return invokeV.intValue;
        }

        private AuthorityPart getAuthorityPart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                AuthorityPart authorityPart = this.authority;
                if (authorityPart == null) {
                    AuthorityPart fromEncoded = AuthorityPart.fromEncoded(encodeAuthority(parseAuthority(this.uriString, findSchemeSeparator())));
                    this.authority = fromEncoded;
                    return fromEncoded;
                }
                return authorityPart;
            }
            return (AuthorityPart) invokeV.objValue;
        }

        public static String parseAuthority(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i2)) == null) {
                int length = str.length();
                int i3 = i2 + 2;
                if (length > i3 && str.charAt(i2 + 1) == '/' && str.charAt(i3) == '/') {
                    int i4 = i2 + 3;
                    int i5 = i4;
                    while (i5 < length) {
                        char charAt = str.charAt(i5);
                        if (charAt == '#' || charAt == '/' || charAt == '?' || charAt == '\\') {
                            break;
                        }
                        i5++;
                    }
                    return str.substring(i4, i5);
                }
                return null;
            }
            return (String) invokeLI.objValue;
        }

        private String parseScheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                int findSchemeSeparator = findSchemeSeparator();
                if (findSchemeSeparator == -1) {
                    return null;
                }
                return this.uriString.substring(0, findSchemeSeparator);
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getEncodedAuthority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getAuthorityPart().getEncoded() : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getScheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.scheme != Uri.NOT_CACHED) {
                    return this.scheme;
                }
                String parseScheme = parseScheme();
                this.scheme = parseScheme;
                return parseScheme;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isHierarchical() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int findSchemeSeparator = findSchemeSeparator();
                if (findSchemeSeparator == -1) {
                    return true;
                }
                int i2 = findSchemeSeparator + 1;
                return this.uriString.length() != i2 && this.uriString.charAt(i2) == '/';
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isRelative() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? findSchemeSeparator() == -1 : invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.uriString : (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringUri(String str) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cachedSsi = -2;
            this.scheme = Uri.NOT_CACHED;
            if (str != null) {
                this.uriString = str;
                return;
            }
            throw new NullPointerException("uriString");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2090129326, "Lcom/baidu/searchbox/v8engine/net/Uri;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2090129326, "Lcom/baidu/searchbox/v8engine/net/Uri;");
                return;
            }
        }
        NOT_CACHED = new String("NOT CACHED");
        HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    }

    public /* synthetic */ Uri(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static String encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? encode(str, null) : (String) invokeL.objValue;
    }

    public static boolean isAllowed(char c2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Character.valueOf(c2), str})) == null) ? (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || !((c2 < '0' || c2 > '9') && "_-.*".indexOf(c2) == -1 && (str == null || str.indexOf(c2) == -1)) : invokeCommon.booleanValue;
    }

    public static Uri parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? new StringUri(str, null) : (Uri) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof Uri) {
                return toString().equals(((Uri) obj).toString());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public abstract String getEncodedAuthority();

    @Nullable
    public abstract String getScheme();

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? toString().hashCode() : invokeV.intValue;
    }

    public boolean isAbsolute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !isRelative() : invokeV.booleanValue;
    }

    public abstract boolean isHierarchical();

    public boolean isOpaque() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? !isHierarchical() : invokeV.booleanValue;
    }

    public abstract boolean isRelative();

    public abstract String toString();

    public Uri() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String encode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            StringBuilder sb = null;
            if (str == null) {
                return null;
            }
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2;
                while (i3 < length && isAllowed(str.charAt(i3), str2)) {
                    i3++;
                }
                if (i3 == length) {
                    if (i2 == 0) {
                        return str;
                    }
                    if (sb != null) {
                        sb.append((CharSequence) str, i2, length);
                        return sb.toString();
                    }
                    return "";
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                if (i3 > i2) {
                    sb.append((CharSequence) str, i2, i3);
                }
                i2 = i3 + 1;
                while (i2 < length && !isAllowed(str.charAt(i2), str2)) {
                    i2++;
                }
                try {
                    byte[] bytes = str.substring(i3, i2).getBytes("UTF-8");
                    int length2 = bytes.length;
                    for (int i4 = 0; i4 < length2; i4++) {
                        sb.append('%');
                        sb.append(HEX_DIGITS[(bytes[i4] & 240) >> 4]);
                        sb.append(HEX_DIGITS[bytes[i4] & 15]);
                    }
                } catch (UnsupportedEncodingException e2) {
                    throw new AssertionError(e2);
                }
            }
            return sb == null ? str : sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) ? toString().compareTo(uri.toString()) : invokeL.intValue;
    }
}
