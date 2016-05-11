package com.baidu.sapi2.dto;
/* loaded from: classes.dex */
public class ReloginDTO extends SapiDTO {
    private PasswordType a;
    public String bduss;
    public String password;

    public ReloginDTO() {
        this(PasswordType.getDefault());
    }

    public ReloginDTO(PasswordType passwordType) {
        this.a = passwordType;
    }

    public PasswordType getPasswordType() {
        return this.a != null ? this.a : PasswordType.getDefault();
    }

    /* loaded from: classes.dex */
    public enum PasswordType {
        PLAIN,
        CIPHER;

        public static PasswordType getDefault() {
            return CIPHER;
        }
    }
}
