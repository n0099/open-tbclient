package com.baidu.gson;

import java.lang.reflect.Field;
/* loaded from: classes.dex */
public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY { // from class: com.baidu.gson.FieldNamingPolicy.1
        @Override // com.baidu.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.baidu.gson.FieldNamingPolicy.2
        @Override // com.baidu.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.baidu.gson.FieldNamingPolicy.3
        @Override // com.baidu.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.baidu.gson.FieldNamingPolicy.4
        @Override // com.baidu.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase();
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.baidu.gson.FieldNamingPolicy.5
        @Override // com.baidu.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase();
        }
    };

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static FieldNamingPolicy[] valuesCustom() {
        FieldNamingPolicy[] valuesCustom = values();
        int length = valuesCustom.length;
        FieldNamingPolicy[] fieldNamingPolicyArr = new FieldNamingPolicy[length];
        System.arraycopy(valuesCustom, 0, fieldNamingPolicyArr, 0, length);
        return fieldNamingPolicyArr;
    }

    /* synthetic */ FieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String upperCaseFirstLetter(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        while (i < str.length() - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i++;
            charAt = str.charAt(i);
        }
        if (i == str.length()) {
            return sb.toString();
        }
        if (!Character.isUpperCase(charAt)) {
            return sb.append(modifyString(Character.toUpperCase(charAt), str, i + 1)).toString();
        }
        return str;
    }

    private static String modifyString(char c, String str, int i) {
        if (i < str.length()) {
            return String.valueOf(c) + str.substring(i);
        }
        return String.valueOf(c);
    }
}
