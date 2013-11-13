package com.baidu.android.nebula.cmd;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class i implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f672a = hVar;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        File file2;
        String str2;
        File file3;
        File file4;
        File file5;
        File file6;
        File file7;
        String str3;
        File file8;
        File file9;
        File file10;
        File file11;
        String lowerCase = str.toLowerCase();
        if (file.getName().startsWith(".") || lowerCase.startsWith(".") || file.getName().startsWith("image") || lowerCase.startsWith("image") || file.getName().startsWith("cache") || lowerCase.startsWith("cache") || file.getName().startsWith("thumb") || lowerCase.startsWith("thumb") || file.getName().startsWith("ting") || lowerCase.startsWith("ting")) {
            return false;
        }
        this.f672a.b = new File(file, lowerCase);
        file2 = this.f672a.f;
        if (file2 == null) {
            h hVar = this.f672a;
            file11 = this.f672a.b;
            hVar.f = file11;
        }
        if (file.isDirectory()) {
            file6 = this.f672a.b;
            if (file6.isFile()) {
                str3 = this.f672a.e;
                if (Pattern.compile(str3).matcher(lowerCase).find()) {
                    file8 = this.f672a.b;
                    long lastModified = file8.lastModified();
                    file9 = this.f672a.f;
                    if (lastModified >= file9.lastModified()) {
                        h hVar2 = this.f672a;
                        file10 = this.f672a.b;
                        hVar2.f = file10;
                        return true;
                    }
                    return true;
                }
            } else {
                file7 = this.f672a.b;
                file7.listFiles(this);
            }
        } else {
            str2 = this.f672a.e;
            if (Pattern.compile(str2).matcher(lowerCase).find()) {
                file3 = this.f672a.b;
                long lastModified2 = file3.lastModified();
                file4 = this.f672a.f;
                if (lastModified2 >= file4.lastModified()) {
                    h hVar3 = this.f672a;
                    file5 = this.f672a.b;
                    hVar3.f = file5;
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
