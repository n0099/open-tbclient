package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Person {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ICON_KEY = "icon";
    public static final String IS_BOT_KEY = "isBot";
    public static final String IS_IMPORTANT_KEY = "isImportant";
    public static final String KEY_KEY = "key";
    public static final String NAME_KEY = "name";
    public static final String URI_KEY = "uri";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public IconCompat mIcon;
    public boolean mIsBot;
    public boolean mIsImportant;
    @Nullable
    public String mKey;
    @Nullable
    public CharSequence mName;
    @Nullable
    public String mUri;

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public IconCompat mIcon;
        public boolean mIsBot;
        public boolean mIsImportant;
        @Nullable
        public String mKey;
        @Nullable
        public CharSequence mName;
        @Nullable
        public String mUri;

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
                }
            }
        }

        @NonNull
        public Person build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Person(this);
            }
            return (Person) invokeV.objValue;
        }

        public Builder(Person person) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {person};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mName = person.mName;
            this.mIcon = person.mIcon;
            this.mUri = person.mUri;
            this.mKey = person.mKey;
            this.mIsBot = person.mIsBot;
            this.mIsImportant = person.mIsImportant;
        }

        @NonNull
        public Builder setBot(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.mIsBot = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @NonNull
        public Builder setIcon(@Nullable IconCompat iconCompat) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iconCompat)) == null) {
                this.mIcon = iconCompat;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setImportant(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.mIsImportant = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @NonNull
        public Builder setKey(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, charSequence)) == null) {
                this.mName = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setUri(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.mUri = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public Person(Builder builder) {
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
        this.mName = builder.mName;
        this.mIcon = builder.mIcon;
        this.mUri = builder.mUri;
        this.mKey = builder.mKey;
        this.mIsBot = builder.mIsBot;
        this.mIsImportant = builder.mIsImportant;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person person) {
        InterceptResult invokeL;
        IconCompat iconCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, person)) == null) {
            Builder name = new Builder().setName(person.getName());
            if (person.getIcon() != null) {
                iconCompat = IconCompat.createFromIcon(person.getIcon());
            } else {
                iconCompat = null;
            }
            return name.setIcon(iconCompat).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }
        return (Person) invokeL.objValue;
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        IconCompat iconCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) {
            Bundle bundle2 = bundle.getBundle("icon");
            Builder name = new Builder().setName(bundle.getCharSequence("name"));
            if (bundle2 != null) {
                iconCompat = IconCompat.createFromBundle(bundle2);
            } else {
                iconCompat = null;
            }
            return name.setIcon(iconCompat).setUri(bundle.getString("uri")).setKey(bundle.getString("key")).setBot(bundle.getBoolean(IS_BOT_KEY)).setImportant(bundle.getBoolean(IS_IMPORTANT_KEY)).build();
        }
        return (Person) invokeL.objValue;
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle persistableBundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, persistableBundle)) == null) {
            return new Builder().setName(persistableBundle.getString("name")).setUri(persistableBundle.getString("uri")).setKey(persistableBundle.getString("key")).setBot(persistableBundle.getBoolean(IS_BOT_KEY)).setImportant(persistableBundle.getBoolean(IS_IMPORTANT_KEY)).build();
        }
        return (Person) invokeL.objValue;
    }

    @Nullable
    public IconCompat getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mIcon;
        }
        return (IconCompat) invokeV.objValue;
    }

    @Nullable
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mKey;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public CharSequence getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mName;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public String getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mUri;
        }
        return (String) invokeV.objValue;
    }

    public boolean isBot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mIsBot;
        }
        return invokeV.booleanValue;
    }

    public boolean isImportant() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mIsImportant;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public Builder toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new Builder(this);
        }
        return (Builder) invokeV.objValue;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        InterceptResult invokeV;
        Icon icon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Person.Builder name = new Person.Builder().setName(getName());
            if (getIcon() != null) {
                icon = getIcon().toIcon();
            } else {
                icon = null;
            }
            return name.setIcon(icon).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
        }
        return (android.app.Person) invokeV.objValue;
    }

    @NonNull
    public Bundle toBundle() {
        InterceptResult invokeV;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putCharSequence("name", this.mName);
            IconCompat iconCompat = this.mIcon;
            if (iconCompat != null) {
                bundle = iconCompat.toBundle();
            } else {
                bundle = null;
            }
            bundle2.putBundle("icon", bundle);
            bundle2.putString("uri", this.mUri);
            bundle2.putString("key", this.mKey);
            bundle2.putBoolean(IS_BOT_KEY, this.mIsBot);
            bundle2.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
            return bundle2;
        }
        return (Bundle) invokeV.objValue;
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = this.mName;
            if (charSequence != null) {
                str = charSequence.toString();
            } else {
                str = null;
            }
            persistableBundle.putString("name", str);
            persistableBundle.putString("uri", this.mUri);
            persistableBundle.putString("key", this.mKey);
            persistableBundle.putBoolean(IS_BOT_KEY, this.mIsBot);
            persistableBundle.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
            return persistableBundle;
        }
        return (PersistableBundle) invokeV.objValue;
    }
}
