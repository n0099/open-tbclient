package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class ShortcutInfoCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_LOCUS_ID = "extraLocusId";
    public static final String EXTRA_LONG_LIVED = "extraLongLived";
    public static final String EXTRA_PERSON_ = "extraPerson_";
    public static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    public static final String EXTRA_SLICE_URI = "extraSliceUri";
    public transient /* synthetic */ FieldHolder $fh;
    public ComponentName mActivity;
    public Set<String> mCategories;
    public Context mContext;
    public CharSequence mDisabledMessage;
    public int mDisabledReason;
    public PersistableBundle mExtras;
    public boolean mHasKeyFieldsOnly;
    public IconCompat mIcon;
    public String mId;
    public Intent[] mIntents;
    public boolean mIsAlwaysBadged;
    public boolean mIsCached;
    public boolean mIsDeclaredInManifest;
    public boolean mIsDynamic;
    public boolean mIsEnabled;
    public boolean mIsImmutable;
    public boolean mIsLongLived;
    public boolean mIsPinned;
    public CharSequence mLabel;
    public long mLastChangedTimestamp;
    @Nullable
    public LocusIdCompat mLocusId;
    public CharSequence mLongLabel;
    public String mPackageName;
    public Person[] mPersons;
    public int mRank;
    public UserHandle mUser;

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        public Set<String> mCapabilityBindings;
        public final ShortcutInfoCompat mInfo;
        public boolean mIsConversation;
        public Uri mSliceUri;

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, shortcutInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = shortcutInfo.getId();
            this.mInfo.mPackageName = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            this.mInfo.mIntents = (Intent[]) Arrays.copyOf(intents, intents.length);
            this.mInfo.mActivity = shortcutInfo.getActivity();
            this.mInfo.mLabel = shortcutInfo.getShortLabel();
            this.mInfo.mLongLabel = shortcutInfo.getLongLabel();
            this.mInfo.mDisabledMessage = shortcutInfo.getDisabledMessage();
            if (Build.VERSION.SDK_INT >= 28) {
                this.mInfo.mDisabledReason = shortcutInfo.getDisabledReason();
            } else {
                ShortcutInfoCompat shortcutInfoCompat2 = this.mInfo;
                if (shortcutInfo.isEnabled()) {
                    i = 0;
                } else {
                    i = 3;
                }
                shortcutInfoCompat2.mDisabledReason = i;
            }
            this.mInfo.mCategories = shortcutInfo.getCategories();
            this.mInfo.mPersons = ShortcutInfoCompat.getPersonsFromExtra(shortcutInfo.getExtras());
            this.mInfo.mUser = shortcutInfo.getUserHandle();
            this.mInfo.mLastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
            if (Build.VERSION.SDK_INT >= 30) {
                this.mInfo.mIsCached = shortcutInfo.isCached();
            }
            this.mInfo.mIsDynamic = shortcutInfo.isDynamic();
            this.mInfo.mIsPinned = shortcutInfo.isPinned();
            this.mInfo.mIsDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
            this.mInfo.mIsImmutable = shortcutInfo.isImmutable();
            this.mInfo.mIsEnabled = shortcutInfo.isEnabled();
            this.mInfo.mHasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
            this.mInfo.mLocusId = ShortcutInfoCompat.getLocusId(shortcutInfo);
            this.mInfo.mRank = shortcutInfo.getRank();
            this.mInfo.mExtras = shortcutInfo.getExtras();
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = str;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat shortcutInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shortcutInfoCompat};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat2;
            shortcutInfoCompat2.mContext = shortcutInfoCompat.mContext;
            shortcutInfoCompat2.mId = shortcutInfoCompat.mId;
            shortcutInfoCompat2.mPackageName = shortcutInfoCompat.mPackageName;
            Intent[] intentArr = shortcutInfoCompat.mIntents;
            shortcutInfoCompat2.mIntents = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            ShortcutInfoCompat shortcutInfoCompat3 = this.mInfo;
            shortcutInfoCompat3.mActivity = shortcutInfoCompat.mActivity;
            shortcutInfoCompat3.mLabel = shortcutInfoCompat.mLabel;
            shortcutInfoCompat3.mLongLabel = shortcutInfoCompat.mLongLabel;
            shortcutInfoCompat3.mDisabledMessage = shortcutInfoCompat.mDisabledMessage;
            shortcutInfoCompat3.mDisabledReason = shortcutInfoCompat.mDisabledReason;
            shortcutInfoCompat3.mIcon = shortcutInfoCompat.mIcon;
            shortcutInfoCompat3.mIsAlwaysBadged = shortcutInfoCompat.mIsAlwaysBadged;
            shortcutInfoCompat3.mUser = shortcutInfoCompat.mUser;
            shortcutInfoCompat3.mLastChangedTimestamp = shortcutInfoCompat.mLastChangedTimestamp;
            shortcutInfoCompat3.mIsCached = shortcutInfoCompat.mIsCached;
            shortcutInfoCompat3.mIsDynamic = shortcutInfoCompat.mIsDynamic;
            shortcutInfoCompat3.mIsPinned = shortcutInfoCompat.mIsPinned;
            shortcutInfoCompat3.mIsDeclaredInManifest = shortcutInfoCompat.mIsDeclaredInManifest;
            shortcutInfoCompat3.mIsImmutable = shortcutInfoCompat.mIsImmutable;
            shortcutInfoCompat3.mIsEnabled = shortcutInfoCompat.mIsEnabled;
            shortcutInfoCompat3.mLocusId = shortcutInfoCompat.mLocusId;
            shortcutInfoCompat3.mIsLongLived = shortcutInfoCompat.mIsLongLived;
            shortcutInfoCompat3.mHasKeyFieldsOnly = shortcutInfoCompat.mHasKeyFieldsOnly;
            shortcutInfoCompat3.mRank = shortcutInfoCompat.mRank;
            Person[] personArr = shortcutInfoCompat.mPersons;
            if (personArr != null) {
                shortcutInfoCompat3.mPersons = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.mCategories != null) {
                this.mInfo.mCategories = new HashSet(shortcutInfoCompat.mCategories);
            }
            PersistableBundle persistableBundle = shortcutInfoCompat.mExtras;
            if (persistableBundle != null) {
                this.mInfo.mExtras = persistableBundle;
            }
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.mCapabilityBindings == null) {
                    this.mCapabilityBindings = new HashSet();
                }
                this.mCapabilityBindings.add(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName componentName) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, componentName)) == null) {
                this.mInfo.mActivity = componentName;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> set) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, set)) == null) {
                this.mInfo.mCategories = set;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, charSequence)) == null) {
                this.mInfo.mDisabledMessage = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setExtras(@NonNull PersistableBundle persistableBundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, persistableBundle)) == null) {
                this.mInfo.mExtras = persistableBundle;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setIcon(IconCompat iconCompat) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iconCompat)) == null) {
                this.mInfo.mIcon = iconCompat;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, intent)) == null) {
                return setIntents(new Intent[]{intent});
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] intentArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, intentArr)) == null) {
                this.mInfo.mIntents = intentArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat locusIdCompat) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, locusIdCompat)) == null) {
                this.mInfo.mLocusId = locusIdCompat;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
                this.mInfo.mLongLabel = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setLongLived(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.mInfo.mIsLongLived = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @NonNull
        public Builder setPerson(@NonNull Person person) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, person)) == null) {
                return setPersons(new Person[]{person});
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] personArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, personArr)) == null) {
                this.mInfo.mPersons = personArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setRank(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
                this.mInfo.mRank = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, charSequence)) == null) {
                this.mInfo.mLabel = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSliceUri(@NonNull Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, uri)) == null) {
                this.mSliceUri = uri;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String str, @NonNull String str2, @NonNull List<String> list) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, list)) == null) {
                addCapabilityBinding(str);
                if (!list.isEmpty()) {
                    if (this.mCapabilityBindingParams == null) {
                        this.mCapabilityBindingParams = new HashMap();
                    }
                    if (this.mCapabilityBindingParams.get(str) == null) {
                        this.mCapabilityBindingParams.put(str, new HashMap());
                    }
                    this.mCapabilityBindingParams.get(str).put(str2, list);
                }
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        @NonNull
        @SuppressLint({"UnsafeNewApiCall"})
        public ShortcutInfoCompat build() {
            InterceptResult invokeV;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!TextUtils.isEmpty(this.mInfo.mLabel)) {
                    ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
                    Intent[] intentArr = shortcutInfoCompat.mIntents;
                    if (intentArr != null && intentArr.length != 0) {
                        if (this.mIsConversation) {
                            if (shortcutInfoCompat.mLocusId == null) {
                                shortcutInfoCompat.mLocusId = new LocusIdCompat(shortcutInfoCompat.mId);
                            }
                            this.mInfo.mIsLongLived = true;
                        }
                        if (this.mCapabilityBindings != null) {
                            ShortcutInfoCompat shortcutInfoCompat2 = this.mInfo;
                            if (shortcutInfoCompat2.mCategories == null) {
                                shortcutInfoCompat2.mCategories = new HashSet();
                            }
                            this.mInfo.mCategories.addAll(this.mCapabilityBindings);
                        }
                        if (Build.VERSION.SDK_INT >= 21) {
                            if (this.mCapabilityBindingParams != null) {
                                ShortcutInfoCompat shortcutInfoCompat3 = this.mInfo;
                                if (shortcutInfoCompat3.mExtras == null) {
                                    shortcutInfoCompat3.mExtras = new PersistableBundle();
                                }
                                for (String str : this.mCapabilityBindingParams.keySet()) {
                                    Map<String, List<String>> map = this.mCapabilityBindingParams.get(str);
                                    this.mInfo.mExtras.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                                    for (String str2 : map.keySet()) {
                                        List<String> list = map.get(str2);
                                        PersistableBundle persistableBundle = this.mInfo.mExtras;
                                        String str3 = str + "/" + str2;
                                        if (list == null) {
                                            strArr = new String[0];
                                        } else {
                                            strArr = (String[]) list.toArray(new String[0]);
                                        }
                                        persistableBundle.putStringArray(str3, strArr);
                                    }
                                }
                            }
                            if (this.mSliceUri != null) {
                                ShortcutInfoCompat shortcutInfoCompat4 = this.mInfo;
                                if (shortcutInfoCompat4.mExtras == null) {
                                    shortcutInfoCompat4.mExtras = new PersistableBundle();
                                }
                                this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
                            }
                        }
                        return this.mInfo;
                    }
                    throw new IllegalArgumentException("Shortcut must have an intent");
                }
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            return (ShortcutInfoCompat) invokeV.objValue;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.mInfo.mIsAlwaysBadged = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        @NonNull
        public Builder setIsConversation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                this.mIsConversation = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                this.mInfo.mIsLongLived = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }
    }

    public ShortcutInfoCompat() {
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
        this.mIsEnabled = true;
    }

    @Nullable
    public ComponentName getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mActivity;
        }
        return (ComponentName) invokeV.objValue;
    }

    @Nullable
    public Set<String> getCategories() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCategories;
        }
        return (Set) invokeV.objValue;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDisabledMessage;
        }
        return (CharSequence) invokeV.objValue;
    }

    public int getDisabledReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDisabledReason;
        }
        return invokeV.intValue;
    }

    @Nullable
    public PersistableBundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mExtras;
        }
        return (PersistableBundle) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mIcon;
        }
        return (IconCompat) invokeV.objValue;
    }

    @NonNull
    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mId;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Intent[] intentArr = this.mIntents;
            return intentArr[intentArr.length - 1];
        }
        return (Intent) invokeV.objValue;
    }

    @NonNull
    public Intent[] getIntents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Intent[] intentArr = this.mIntents;
            return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
        }
        return (Intent[]) invokeV.objValue;
    }

    public long getLastChangedTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mLastChangedTimestamp;
        }
        return invokeV.longValue;
    }

    @Nullable
    public LocusIdCompat getLocusId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mLocusId;
        }
        return (LocusIdCompat) invokeV.objValue;
    }

    @Nullable
    public CharSequence getLongLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mLongLabel;
        }
        return (CharSequence) invokeV.objValue;
    }

    @NonNull
    public String getPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mPackageName;
        }
        return (String) invokeV.objValue;
    }

    public int getRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mRank;
        }
        return invokeV.intValue;
    }

    @NonNull
    public CharSequence getShortLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mLabel;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public UserHandle getUserHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mUser;
        }
        return (UserHandle) invokeV.objValue;
    }

    public boolean hasKeyFieldsOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mHasKeyFieldsOnly;
        }
        return invokeV.booleanValue;
    }

    public boolean isCached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mIsCached;
        }
        return invokeV.booleanValue;
    }

    public boolean isDeclaredInManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mIsDeclaredInManifest;
        }
        return invokeV.booleanValue;
    }

    public boolean isDynamic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mIsDynamic;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mIsEnabled;
        }
        return invokeV.booleanValue;
    }

    public boolean isImmutable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mIsImmutable;
        }
        return invokeV.booleanValue;
    }

    public boolean isPinned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mIsPinned;
        }
        return invokeV.booleanValue;
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle buildLegacyExtrasBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mExtras == null) {
                this.mExtras = new PersistableBundle();
            }
            Person[] personArr = this.mPersons;
            if (personArr != null && personArr.length > 0) {
                this.mExtras.putInt(EXTRA_PERSON_COUNT, personArr.length);
                int i = 0;
                while (i < this.mPersons.length) {
                    PersistableBundle persistableBundle = this.mExtras;
                    StringBuilder sb = new StringBuilder();
                    sb.append(EXTRA_PERSON_);
                    int i2 = i + 1;
                    sb.append(i2);
                    persistableBundle.putPersistableBundle(sb.toString(), this.mPersons[i].toPersistableBundle());
                    i = i2;
                }
            }
            LocusIdCompat locusIdCompat = this.mLocusId;
            if (locusIdCompat != null) {
                this.mExtras.putString(EXTRA_LOCUS_ID, locusIdCompat.getId());
            }
            this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
            return this.mExtras;
        }
        return (PersistableBundle) invokeV.objValue;
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static List<ShortcutInfoCompat> fromShortcuts(@NonNull Context context, @NonNull List<ShortcutInfo> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (ShortcutInfo shortcutInfo : list) {
                arrayList.add(new Builder(context, shortcutInfo).build());
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @Nullable
    @RequiresApi(25)
    public static LocusIdCompat getLocusId(@NonNull ShortcutInfo shortcutInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, shortcutInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                if (shortcutInfo.getLocusId() == null) {
                    return null;
                }
                return LocusIdCompat.toLocusIdCompat(shortcutInfo.getLocusId());
            }
            return getLocusIdFromExtra(shortcutInfo.getExtras());
        }
        return (LocusIdCompat) invokeL.objValue;
    }

    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static LocusIdCompat getLocusIdFromExtra(@Nullable PersistableBundle persistableBundle) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, persistableBundle)) == null) {
            if (persistableBundle == null || (string = persistableBundle.getString(EXTRA_LOCUS_ID)) == null) {
                return null;
            }
            return new LocusIdCompat(string);
        }
        return (LocusIdCompat) invokeL.objValue;
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static boolean getLongLivedFromExtra(@Nullable PersistableBundle persistableBundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, persistableBundle)) == null) {
            if (persistableBundle != null && persistableBundle.containsKey(EXTRA_LONG_LIVED)) {
                return persistableBundle.getBoolean(EXTRA_LONG_LIVED);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person[] getPersonsFromExtra(@NonNull PersistableBundle persistableBundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, persistableBundle)) == null) {
            if (persistableBundle != null && persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
                int i = persistableBundle.getInt(EXTRA_PERSON_COUNT);
                Person[] personArr = new Person[i];
                int i2 = 0;
                while (i2 < i) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(EXTRA_PERSON_);
                    int i3 = i2 + 1;
                    sb.append(i3);
                    personArr[i2] = Person.fromPersistableBundle(persistableBundle.getPersistableBundle(sb.toString()));
                    i2 = i3;
                }
                return personArr;
            }
            return null;
        }
        return (Person[]) invokeL.objValue;
    }

    public Intent addToIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            Intent[] intentArr = this.mIntents;
            intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
            if (this.mIcon != null) {
                Drawable drawable = null;
                if (this.mIsAlwaysBadged) {
                    PackageManager packageManager = this.mContext.getPackageManager();
                    ComponentName componentName = this.mActivity;
                    if (componentName != null) {
                        try {
                            drawable = packageManager.getActivityIcon(componentName);
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                    }
                    if (drawable == null) {
                        drawable = this.mContext.getApplicationInfo().loadIcon(packageManager);
                    }
                }
                this.mIcon.addToShortcutIntent(intent, drawable, this.mContext);
            }
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
            IconCompat iconCompat = this.mIcon;
            if (iconCompat != null) {
                intents.setIcon(iconCompat.toIcon(this.mContext));
            }
            if (!TextUtils.isEmpty(this.mLongLabel)) {
                intents.setLongLabel(this.mLongLabel);
            }
            if (!TextUtils.isEmpty(this.mDisabledMessage)) {
                intents.setDisabledMessage(this.mDisabledMessage);
            }
            ComponentName componentName = this.mActivity;
            if (componentName != null) {
                intents.setActivity(componentName);
            }
            Set<String> set = this.mCategories;
            if (set != null) {
                intents.setCategories(set);
            }
            intents.setRank(this.mRank);
            PersistableBundle persistableBundle = this.mExtras;
            if (persistableBundle != null) {
                intents.setExtras(persistableBundle);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Person[] personArr = this.mPersons;
                if (personArr != null && personArr.length > 0) {
                    int length = personArr.length;
                    android.app.Person[] personArr2 = new android.app.Person[length];
                    for (int i = 0; i < length; i++) {
                        personArr2[i] = this.mPersons[i].toAndroidPerson();
                    }
                    intents.setPersons(personArr2);
                }
                LocusIdCompat locusIdCompat = this.mLocusId;
                if (locusIdCompat != null) {
                    intents.setLocusId(locusIdCompat.toLocusId());
                }
                intents.setLongLived(this.mIsLongLived);
            } else {
                intents.setExtras(buildLegacyExtrasBundle());
            }
            return intents.build();
        }
        return (ShortcutInfo) invokeV.objValue;
    }
}
