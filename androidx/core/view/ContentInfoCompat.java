package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class ContentInfoCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ClipData mClip;
    @Nullable
    public final Bundle mExtras;
    public final int mFlags;
    @Nullable
    public final Uri mLinkUri;
    public final int mSource;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Source {
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public ClipData mClip;
        @Nullable
        public Bundle mExtras;
        public int mFlags;
        @Nullable
        public Uri mLinkUri;
        public int mSource;

        public Builder(@NonNull ClipData clipData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clipData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mClip = clipData;
            this.mSource = i;
        }

        public Builder(@NonNull ContentInfoCompat contentInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentInfoCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mClip = contentInfoCompat.mClip;
            this.mSource = contentInfoCompat.mSource;
            this.mFlags = contentInfoCompat.mFlags;
            this.mLinkUri = contentInfoCompat.mLinkUri;
            this.mExtras = contentInfoCompat.mExtras;
        }

        @NonNull
        public ContentInfoCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new ContentInfoCompat(this);
            }
            return (ContentInfoCompat) invokeV.objValue;
        }

        @NonNull
        public Builder setClip(@NonNull ClipData clipData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clipData)) == null) {
                this.mClip = clipData;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                this.mExtras = bundle;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setFlags(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.mFlags = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) {
                this.mLinkUri = uri;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setSource(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.mSource = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    public ContentInfoCompat(Builder builder) {
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
        this.mClip = (ClipData) Preconditions.checkNotNull(builder.mClip);
        this.mSource = Preconditions.checkArgumentInRange(builder.mSource, 0, 3, "source");
        this.mFlags = Preconditions.checkFlagsArgument(builder.mFlags, 1);
        this.mLinkUri = builder.mLinkUri;
        this.mExtras = builder.mExtras;
    }

    public static ClipData buildClipData(ClipDescription clipDescription, List<ClipData.Item> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, clipDescription, list)) == null) {
            ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
            for (int i = 1; i < list.size(); i++) {
                clipData.addItem(list.get(i));
            }
            return clipData;
        }
        return (ClipData) invokeLL.objValue;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static String flagsToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if ((i & 1) != 0) {
                return "FLAG_CONVERT_TO_PLAIN_TEXT";
            }
            return String.valueOf(i);
        }
        return (String) invokeI.objValue;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static String sourceToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return String.valueOf(i);
                        }
                        return "SOURCE_DRAG_AND_DROP";
                    }
                    return "SOURCE_INPUT_METHOD";
                }
                return "SOURCE_CLIPBOARD";
            }
            return "SOURCE_APP";
        }
        return (String) invokeI.objValue;
    }

    @NonNull
    public ClipData getClip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mClip;
        }
        return (ClipData) invokeV.objValue;
    }

    @Nullable
    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mExtras;
        }
        return (Bundle) invokeV.objValue;
    }

    public int getFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mFlags;
        }
        return invokeV.intValue;
    }

    @Nullable
    public Uri getLinkUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mLinkUri;
        }
        return (Uri) invokeV.objValue;
    }

    public int getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSource;
        }
        return invokeV.intValue;
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull Predicate<ClipData.Item> predicate) {
        InterceptResult invokeL;
        ContentInfoCompat contentInfoCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, predicate)) == null) {
            ContentInfoCompat contentInfoCompat2 = null;
            if (this.mClip.getItemCount() == 1) {
                boolean test = predicate.test(this.mClip.getItemAt(0));
                if (test) {
                    contentInfoCompat = this;
                } else {
                    contentInfoCompat = null;
                }
                if (!test) {
                    contentInfoCompat2 = this;
                }
                return Pair.create(contentInfoCompat, contentInfoCompat2);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.mClip.getItemCount(); i++) {
                ClipData.Item itemAt = this.mClip.getItemAt(i);
                if (predicate.test(itemAt)) {
                    arrayList.add(itemAt);
                } else {
                    arrayList2.add(itemAt);
                }
            }
            if (arrayList.isEmpty()) {
                return Pair.create(null, this);
            }
            if (arrayList2.isEmpty()) {
                return Pair.create(this, null);
            }
            return Pair.create(new Builder(this).setClip(buildClipData(this.mClip.getDescription(), arrayList)).build(), new Builder(this).setClip(buildClipData(this.mClip.getDescription(), arrayList2)).build());
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.mClip.getDescription());
            sb.append(", source=");
            sb.append(sourceToString(this.mSource));
            sb.append(", flags=");
            sb.append(flagsToString(this.mFlags));
            String str2 = "";
            if (this.mLinkUri == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.mLinkUri.toString().length() + SmallTailInfo.EMOTION_SUFFIX;
            }
            sb.append(str);
            if (this.mExtras != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
