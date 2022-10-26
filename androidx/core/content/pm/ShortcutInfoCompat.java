package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class ShortcutInfoCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_LONG_LIVED = "extraLongLived";
    public static final String EXTRA_PERSON_ = "extraPerson_";
    public static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    public transient /* synthetic */ FieldHolder $fh;
    public ComponentName mActivity;
    public Set<String> mCategories;
    public Context mContext;
    public CharSequence mDisabledMessage;
    public IconCompat mIcon;
    public String mId;
    public Intent[] mIntents;
    public boolean mIsAlwaysBadged;
    public boolean mIsLongLived;
    public CharSequence mLabel;
    public CharSequence mLongLabel;
    public Person[] mPersons;
    public int mRank;

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ShortcutInfoCompat mInfo;

        public Builder(Context context, ShortcutInfo shortcutInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, shortcutInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = shortcutInfo.getId();
            Intent[] intents = shortcutInfo.getIntents();
            this.mInfo.mIntents = (Intent[]) Arrays.copyOf(intents, intents.length);
            this.mInfo.mActivity = shortcutInfo.getActivity();
            this.mInfo.mLabel = shortcutInfo.getShortLabel();
            this.mInfo.mLongLabel = shortcutInfo.getLongLabel();
            this.mInfo.mDisabledMessage = shortcutInfo.getDisabledMessage();
            this.mInfo.mCategories = shortcutInfo.getCategories();
            this.mInfo.mPersons = ShortcutInfoCompat.getPersonsFromExtra(shortcutInfo.getExtras());
            this.mInfo.mRank = shortcutInfo.getRank();
        }

        public Builder(Context context, String str) {
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

        public Builder(ShortcutInfoCompat shortcutInfoCompat) {
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
            Intent[] intentArr = shortcutInfoCompat.mIntents;
            shortcutInfoCompat2.mIntents = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            ShortcutInfoCompat shortcutInfoCompat3 = this.mInfo;
            shortcutInfoCompat3.mActivity = shortcutInfoCompat.mActivity;
            shortcutInfoCompat3.mLabel = shortcutInfoCompat.mLabel;
            shortcutInfoCompat3.mLongLabel = shortcutInfoCompat.mLongLabel;
            shortcutInfoCompat3.mDisabledMessage = shortcutInfoCompat.mDisabledMessage;
            shortcutInfoCompat3.mIcon = shortcutInfoCompat.mIcon;
            shortcutInfoCompat3.mIsAlwaysBadged = shortcutInfoCompat.mIsAlwaysBadged;
            shortcutInfoCompat3.mIsLongLived = shortcutInfoCompat.mIsLongLived;
            shortcutInfoCompat3.mRank = shortcutInfoCompat.mRank;
            Person[] personArr = shortcutInfoCompat.mPersons;
            if (personArr != null) {
                shortcutInfoCompat3.mPersons = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.mCategories != null) {
                this.mInfo.mCategories = new HashSet(shortcutInfoCompat.mCategories);
            }
        }

        public ShortcutInfoCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.mInfo.mLabel)) {
                    ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
                    Intent[] intentArr = shortcutInfoCompat.mIntents;
                    if (intentArr != null && intentArr.length != 0) {
                        return shortcutInfoCompat;
                    }
                    throw new IllegalArgumentException("Shortcut must have an intent");
                }
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            return (ShortcutInfoCompat) invokeV.objValue;
        }

        public Builder setActivity(ComponentName componentName) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName)) == null) {
                this.mInfo.mActivity = componentName;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCategories(Set<String> set) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, set)) == null) {
                this.mInfo.mCategories = set;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDisabledMessage(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, charSequence)) == null) {
                this.mInfo.mDisabledMessage = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIcon(IconCompat iconCompat) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iconCompat)) == null) {
                this.mInfo.mIcon = iconCompat;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIntent(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intent)) == null) {
                return setIntents(new Intent[]{intent});
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIntents(Intent[] intentArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, intentArr)) == null) {
                this.mInfo.mIntents = intentArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLongLabel(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence)) == null) {
                this.mInfo.mLongLabel = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLongLived(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.mInfo.mIsLongLived = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setPerson(Person person) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, person)) == null) {
                return setPersons(new Person[]{person});
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPersons(Person[] personArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, personArr)) == null) {
                this.mInfo.mPersons = personArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRank(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                this.mInfo.mRank = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setShortLabel(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, charSequence)) == null) {
                this.mInfo.mLabel = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAlwaysBadged() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.mInfo.mIsAlwaysBadged = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        @Deprecated
        public Builder setLongLived() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            }
        }
    }

    public ComponentName getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mActivity;
        }
        return (ComponentName) invokeV.objValue;
    }

    public Set<String> getCategories() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCategories;
        }
        return (Set) invokeV.objValue;
    }

    public CharSequence getDisabledMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDisabledMessage;
        }
        return (CharSequence) invokeV.objValue;
    }

    public IconCompat getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mIcon;
        }
        return (IconCompat) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mId;
        }
        return (String) invokeV.objValue;
    }

    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Intent[] intentArr = this.mIntents;
            return intentArr[intentArr.length - 1];
        }
        return (Intent) invokeV.objValue;
    }

    public Intent[] getIntents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Intent[] intentArr = this.mIntents;
            return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
        }
        return (Intent[]) invokeV.objValue;
    }

    public CharSequence getLongLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mLongLabel;
        }
        return (CharSequence) invokeV.objValue;
    }

    public int getRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mRank;
        }
        return invokeV.intValue;
    }

    public CharSequence getShortLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mLabel;
        }
        return (CharSequence) invokeV.objValue;
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            PersistableBundle persistableBundle = new PersistableBundle();
            Person[] personArr = this.mPersons;
            if (personArr != null && personArr.length > 0) {
                persistableBundle.putInt(EXTRA_PERSON_COUNT, personArr.length);
                int i = 0;
                while (i < this.mPersons.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(EXTRA_PERSON_);
                    int i2 = i + 1;
                    sb.append(i2);
                    persistableBundle.putPersistableBundle(sb.toString(), this.mPersons[i].toPersistableBundle());
                    i = i2;
                }
            }
            persistableBundle.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
            return persistableBundle;
        }
        return (PersistableBundle) invokeV.objValue;
    }

    public static boolean getLongLivedFromExtra(PersistableBundle persistableBundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, persistableBundle)) == null) {
            if (persistableBundle != null && persistableBundle.containsKey(EXTRA_LONG_LIVED)) {
                return persistableBundle.getBoolean(EXTRA_LONG_LIVED);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Person[] getPersonsFromExtra(PersistableBundle persistableBundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, persistableBundle)) == null) {
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

    public ShortcutInfo toShortcutInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
                intents.setLongLived(this.mIsLongLived);
            } else {
                intents.setExtras(buildLegacyExtrasBundle());
            }
            return intents.build();
        }
        return (ShortcutInfo) invokeV.objValue;
    }
}
