package com.alipay.security.mobile.module.deviceinfo;

import com.bumptech.glide.load.engine.executor.RuntimeCompat;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f2073a;

    public c(b bVar) {
        this.f2073a = bVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return Pattern.matches(RuntimeCompat.CPU_NAME_REGEX, file.getName());
    }
}
